package ui.screens

import androidx.compose.runtime.Composable
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
//import ui.components.form.HardwareForm

//@OptIn(DelicateCoroutinesApi::class)
//@Composable
//fun HardwareInsert(onNavigate: (Screen) -> Unit) {
//
//    HardwareForm(onSubmit = { hardware ->
//        GlobalScope.launch {
//            HTT.postNewHardware(hardware)
//        }
//        onNavigate(Screen.HARDWARE)
//    })
//}