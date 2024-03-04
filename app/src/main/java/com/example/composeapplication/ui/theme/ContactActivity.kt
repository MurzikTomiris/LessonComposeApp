package com.example.composeapplication.ui.theme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composeapplication.ui.theme.ui.theme.ComposeApplicationTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeapplication.R

class ContactActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactScreen()
                }
            }
        }
    }
}

data class Contact(
    val name: String,
    val imageUrl: Int
)

private fun generateContactList(): List<Contact> {
    val contactNames = listOf(
        "John Doe", "Jane Smith", "Alex Johnson", "Emily Brown", "Michael Wilson",
        "Sophia Taylor", "James Anderson", "Olivia Martinez", "William Jackson", "Emma Garcia"
    )

    // Фиктивные изображения для контактов
    val imageIds = R.drawable.ic_launcher_foreground

    return contactNames.mapIndexed { _, name ->
        Contact(name = name, imageUrl = imageIds)
    }
}

@Composable
fun ContactListItem(contact: Contact){
    Surface (
        modifier = Modifier.padding(15.dp)
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = contact.imageUrl),
                contentDescription = null, // Content description can be null for decorative images
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                    text = contact.name,
                    modifier = Modifier.padding(16.dp))
            }
        }
    }


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen() {
    val contacts = generateContactList()

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    Surface (
        modifier = Modifier.fillMaxWidth()

    ) {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text("Контакты", fontSize = 20.sp) },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = "Назад"
                            )
                        }
                        Spacer(Modifier.weight(1f, true))
                        Text("Контакты", fontSize = 20.sp)
                        Spacer(Modifier.weight(1f, true))
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "Добавить"
                            )
                        }
                    }
                )
            },

            content = {
                Column(
                    modifier = Modifier.padding(top = 50.dp)
                ){
                    SearchBar(query = text,
                        onQueryChange = { text = it },
                        onSearch = {active = false},
                        active = active,
                        onActiveChange = {active = it},
                        modifier = Modifier.padding(20.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Поиск")
                        }
                    ) { }
                    LazyColumn {
                        items(contacts) { contact ->
                            ContactListItem(contact = contact)
                        }
                    }
                }

            }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
    ComposeApplicationTheme {
        ContactScreen()
    }
}

/*
topBar = {
                TopAppBar(
                    title = { Text("Контакты", fontSize = 20.sp) },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = "Назад"
                            )
                        }
                        Spacer(Modifier.weight(1f, true))
                        Spacer(Modifier.weight(1f, true))
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "Добавить"
                            )
                        }
                    }
                )
            }

 */

/*
SearchBar(query = text,
                onQueryChange = { text = it },
                onSearch = {active = false},
                active = active,
                onActiveChange = {active = it},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Поиск")
                }) { }
 */

/*LazyColumn {
            item {
                Text(text = "Список контактов")
            }
            item{
                LazyRow {
                    item{
                        Text(text = "Фильтр: ")
                    }
                    items(itemList){item->
                        Text(
                            text = item,
                            modifier = Modifier.padding(16.dp))
                    }
                }
            }
            items(itemList){item->
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp))
            }
        }*/