package com.example.lab4.calculateCurrent

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4.calculateCurrent.models.CalculateCurrentInputModel
import com.example.lab4.calculateCurrent.models.CalculateCurrentResultModel
import androidx.compose.runtime.livedata.observeAsState
import com.example.lab4.ui.theme.Lab4Theme


@Composable
fun CalculateCurrentView(viewModel: CalculateCurrentViewModel = CalculateCurrentViewModel()) {
    val inputData by viewModel.inputData.observeAsState(CalculateCurrentInputModel())
    val resultData by viewModel.resultData.observeAsState(CalculateCurrentResultModel())
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = inputData.Ukmax.toString(),
                    onValueChange = { viewModel.updateUkmax(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Ukmax") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.Uvn.toString(),
                    onValueChange = { viewModel.updateUvn(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Uvn") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.Unn.toString(),
                    onValueChange = { viewModel.updateUnn(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Unn") },
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
                    value = inputData.Xch.toString(),
                    onValueChange = { viewModel.updateXch(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Xch") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.Xcmin.toString(),
                    onValueChange = { viewModel.updateXcmin(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Xcmin") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.Rch.toString(),
                    onValueChange = { viewModel.updateRch(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Rch") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.Rcmin.toString(),
                    onValueChange = { viewModel.updateRcmin(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Rcmin") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.Ll.toString(),
                    onValueChange = { viewModel.updateLl(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Ll") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.R0.toString(),
                    onValueChange = { viewModel.updateR0(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("R0") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.X0.toString(),
                    onValueChange = { viewModel.updateX0(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("X0") },
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
                            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                                Text("Rsh: ${resultData.Rsh}")
                                Text("Xsh: ${resultData.Xsh}")
                                Text("Zsh: ${resultData.Zsh}")
                                Text("Rshmin: ${resultData.Rshmin}")
                                Text("Xshmin: ${resultData.Xshmin}")
                                Text("Zshmin: ${resultData.Zshmin}")
                                Text("I3sh: ${resultData.I3sh}")
                                Text("I2sh: ${resultData.I2sh}")
                                Text("I3shmin: ${resultData.I3shmin}")
                                Text("I2shmin: ${resultData.I2shmin}")
                                Text("kpr: ${resultData.kpr}")
                                Text("Rshn: ${resultData.Rshn}")
                                Text("Xshn: ${resultData.Xshn}")
                                Text("Zshn: ${resultData.Zshn}")
                                Text("Rshnmin: ${resultData.Rshnmin}")
                                Text("Xshnmin: ${resultData.Xshnmin}")
                                Text("Zshnmin: ${resultData.Zshnmin}")
                                Text("I3shn: ${resultData.I3shn}")
                                Text("I2shn: ${resultData.I2shn}")
                                Text("I3shnmin: ${resultData.I3shnmin}")
                                Text("I2shnmin: ${resultData.I2shnmin}")
                                Text("Rl: ${resultData.Rl}")
                                Text("Xl: ${resultData.Xl}")
                                Text("Rcn: ${resultData.Rcn}")
                                Text("Xcn: ${resultData.Xcn}")
                                Text("Zcn: ${resultData.Zcn}")
                                Text("Rcnmin: ${resultData.Rcnmin}")
                                Text("Xcnmin: ${resultData.Xcnmin}")
                                Text("Zcnmin: ${resultData.Zcnmin}")
                                Text("I3ln: ${resultData.I3ln}")
                                Text("I2ln: ${resultData.I2ln}")
                                Text("I3lnmin: ${resultData.I3lnmin}")
                                Text("I2lnmin: ${resultData.I2lnmin}")
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
fun CalculateCurrentViewPreview() {
    Lab4Theme {
        CalculateCurrentView()
    }
}
