package com.example.lab4.calculateCurrentOn10

import androidx.compose.runtime.Composable


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab4.calculateCurrentOn10.models.CalculateCurrentOnTenInputModel
import com.example.lab4.calculateCurrentOn10.models.CalculateCurrentOnTenResultModel
import androidx.compose.runtime.livedata.observeAsState
import com.example.lab4.ui.theme.Lab4Theme

@Composable
fun CalculateCurrentOnTenView(viewModel: CalculateCurrentOnTenViewModel = viewModel()) {
    val inputData by viewModel.inputData.observeAsState(CalculateCurrentOnTenInputModel())
    val resultData by viewModel.resultData.observeAsState(CalculateCurrentOnTenResultModel())
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                OutlinedTextField(
                    value = inputData.Sk.toString(),
                    onValueChange = { viewModel.updateSk(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Sk") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = inputData.Uch.toString(),
                    onValueChange = { viewModel.updateUch(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Uch") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = inputData.Snomt.toString(),
                    onValueChange = { viewModel.updateSnomt(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Snomt") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = inputData.Uk.toString(),
                    onValueChange = { viewModel.updateUk(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Uk") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    viewModel.calculateResult()
                    openDialog.value = true
                }) {
                    Text("Calculate")
                }

                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog.value = false },
                        title = { Text("Calculation Result") },
                        text = {
                            Column {
                                Text("Xc: ${resultData.Xc}")
                                Text("Xt: ${resultData.Xt}")
                                Text("X: ${resultData.X}")
                                Text("Ip0: ${resultData.Ip0}")
                            }
                        },
                        confirmButton = {
                            TextButton(onClick = { openDialog.value = false }) {
                                Text("OK")
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CalculateCurrentOnTenScreenPreview() {
    Lab4Theme {
        CalculateCurrentOnTenView()
    }
}
