package com.manubett.news.core.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(
    autoFocus: Boolean,
//    viewModel: SearchViewModel = hiltViewModel(),
    onSearch: () -> Unit
) {

   Box(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, bottom = 8.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.onSecondary)
            .fillMaxWidth()
            .height(54.dp)
    ) {
        var searchInput: String by remember { mutableStateOf("") }
        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current
       var text by remember {
           mutableStateOf("")
       }
        LaunchedEffect(key1 = searchInput) {
//            if (viewModel.searchParam.value.trim().isNotEmpty() &&
//                viewModel.searchParam.value.trim().length != viewModel.previousSearch.value.length
//            ) {
//                delay(750)
//                onSearch()
//                viewModel.previousSearch.value = searchInput.trim()
//            }
        }

        TextField(
//            value = searchInput,
            value = text,
            onValueChange = {
//                    newValue ->
//                searchInput = if (newValue.trim().isNotEmpty()) newValue else ""
//                viewModel.searchParam.value = searchInput
                text = text
            },
            modifier = Modifier
                .fillMaxSize()
                .focusRequester(focusRequester = focusRequester),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Search...",
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8F)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White.copy(alpha = 0.78F),
                disabledTextColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                ), keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
//                    if (viewModel.searchParam.value.trim().isNotEmpty()) {
//                        focusManager.clearFocus()
//                        viewModel.searchParam.value = searchInput
//                        if (searchInput != viewModel.previousSearch.value) {
//                            viewModel.previousSearch.value = searchInput
//                            onSearch()
//                        }
//                    }
                }
            ),
            trailingIcon = {
                LaunchedEffect(Unit) {
                    if (autoFocus) {
                        focusRequester.requestFocus()
                    }
                }
                Row {
                    AnimatedVisibility(visible = searchInput.trim().isNotEmpty()) {
                        IconButton(onClick = {

                            focusManager.clearFocus()
                            searchInput = ""
//                            viewModel.searchParam.value = ""
                        }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                tint = MaterialTheme.colorScheme.primary,
                                contentDescription = null
                            )
                        }
                    }

                    IconButton(onClick = {
//                        if (viewModel.searchParam.value.trim().isNotEmpty()) {
//                            focusManager.clearFocus()
//                            viewModel.searchParam.value = searchInput
//                            if (searchInput != viewModel.previousSearch.value) {
//                                viewModel.previousSearch.value = searchInput
//                                onSearch()
//                            }
//                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = null
                        )
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPrev() {
    SearchBar(autoFocus = true) {

    }
}