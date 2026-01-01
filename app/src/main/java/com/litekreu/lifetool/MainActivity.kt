package com.litekreu.lifetool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.litekreu.lifetool.features.note.NoteViewModel
import com.litekreu.lifetool.features.note.classes.Note
import com.litekreu.lifetool.ui.theme.LifetoolTheme
import com.litekreu.lifetool.ui.theme.googleSansFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LifetoolTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    vm: NoteViewModel = hiltViewModel()
) {
    val notes by vm.notes.collectAsStateWithLifecycle()
    var hi by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(if (hi) 48.dp else 0.dp)

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.inversePrimary)
            .width(240.dp + extraPadding)
    ) {
        Text(
            text = "Hello $name!",
            fontFamily = googleSansFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            modifier = modifier
        )
        ElevatedButton(onClick = { hi = !hi }) {
            Text(hi.toString())
        }
        LazyColumn {
            items(items = notes, key = { it.id }) { note ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(note.id.slice(0..3))
                        Text(note.title)
                        Text(note.text)
                        Text(note.createdDateFormatted)
                    }
                    Button(onClick = { vm.deleteNoteById(note.id) }) {
                        Text("Delete note")
                    }
                }
            }
        }
        Button(onClick = {
            vm.addNote(
                Note(
                    title = "First note",
                    text = "Note description",
                )
            )
        }) {
            Text("Insert")
        }
    }
}