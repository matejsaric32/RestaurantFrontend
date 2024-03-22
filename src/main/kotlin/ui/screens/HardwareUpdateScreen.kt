package ui.screens

import androidx.compose.runtime.Composable
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
//import ui.components.form.HardwareForm

//@OptIn(DelicateCoroutinesApi::class)
//@Composable
//fun HardwareUpdate(onNavigate: (Screen) -> Unit) {
//    HardwareForm(
//        hardware = AppState.selectedHardware,
//        onSubmit = { hardware ->
//        GlobalScope.launch {
//            HTT.putHardware(hardware)
//        }
//        onNavigate(Screen.HARDWARE)
//    })
//}