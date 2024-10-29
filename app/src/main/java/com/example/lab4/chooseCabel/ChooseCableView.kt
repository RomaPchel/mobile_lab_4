package com.example.lab4.chooseCabel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab4.chooseCabel.models.ChooseCableInputModel
import com.example.lab4.chooseCabel.models.ChooseCableResultModel
import com.example.lab4.ui.theme.Lab4Theme
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun ChooseCableView(viewModel: ChooseCableViewModel = viewModel()) {
    val inputData by viewModel.inputData.observeAsState(ChooseCableInputModel())
    val resultData by viewModel.resultData.observeAsState(ChooseCableResultModel())
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = inputData.Unom.toString(),
                    onValueChange = { viewModel.updateUnom(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Unom") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = inputData.Ik.toString(),
                    onValueChange = { viewModel.updateIk(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Ik") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = inputData.tf.toString(),
                    onValueChange = { viewModel.updateTf(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("tf") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = inputData.Sm.toString(),
                    onValueChange = { viewModel.updateSm(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Sm") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = inputData.jek.toString(),
                    onValueChange = { viewModel.updateJek(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("jek") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = inputData.ct.toString(),
                    onValueChange = { viewModel.updateCt(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Ct") },
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
                                Text("Im: ${resultData.Im}")
                                Text("Impa: ${resultData.Impa}")
                                Text("Sek: ${resultData.sek}")
                                Text("S: ${resultData.s}")
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
fun ChooseCablePreview() {
    Lab4Theme {
        ChooseCableView(ChooseCableViewModel())
    }
}
