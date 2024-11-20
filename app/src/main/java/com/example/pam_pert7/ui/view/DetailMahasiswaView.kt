package com.example.pam_pert7.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pam_pert7.model.Mahasiswa


@Composable
fun DetailMahasiswaView(
    dataMhs : Mahasiswa,
    modifier: Modifier = Modifier,
    onBackButton: () -> Unit
){
    val listDataMhs = listOf(
        Pair("Nama", dataMhs.nama),
        Pair("Gender", dataMhs.gender),
        Pair("Alamat", dataMhs.alamat),
        Pair("Nim", dataMhs.nim),
        )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //button
        ElevatedButton(
            onClick = { onBackButton() }
        ) {
            Text("Kembali")
        }

        listDataMhs.forEach { data->
            DetailMhs(
                judul = data.first,
                Isi = data.second
            )
        }
    }
}

@Composable
fun DetailMhs(
    judul: String,
    Isi : String,
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Text(judul,
            modifier = Modifier.weight(0.8f))
        Text(":",
            modifier = Modifier.weight(0.1f))
        Text(Isi,
            modifier = Modifier.weight(2f))
    }
}