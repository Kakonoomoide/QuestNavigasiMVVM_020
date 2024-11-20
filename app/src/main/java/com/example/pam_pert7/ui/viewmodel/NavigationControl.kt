package com.example.pam_pert7.ui.viewmodel

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam_pert7.model.ListGender
import com.example.pam_pert7.ui.view.DetailMahasiswaView
import com.example.pam_pert7.ui.view.FormMahasiswaView

enum class Halaman{
    DETAILMAHASISWA,
    FORMMAHASISWA
}

@Composable
fun NavigatorControl(
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController(),
    modifier: Any
){
    val uiState by viewModel.dataModel.collectAsState()
    //val _dataModel by viewModel.dataModel.collectAsState()
    NavHost(
        navController = navHost,
        startDestination = Halaman.FORMMAHASISWA.name
    ){
        composable(route = Halaman.FORMMAHASISWA.name){
            val konteks = LocalContext.current
            FormMahasiswaView(
                listgender = ListGender.listGender.map { id -> konteks.getString(id) },
                onSubmitClick = { listData ->
                    viewModel.saveDataMhs(listData)
                    navHost.navigate(Halaman.DETAILMAHASISWA.name)
                }
            )
        }

        composable(route = Halaman.DETAILMAHASISWA.name) {
            DetailMahasiswaView(
                dataMhs = uiState,
                modifier = Modifier,
                onBackButton = { navHost.popBackStack() }
            )
        }
    }
}