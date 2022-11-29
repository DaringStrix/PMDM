package com.example.projectalphajet

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectalphajet.ui.theme.PurpleBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {

            AppView()
        }
    }
//        }
}

val txCuenta = mutableStateOf("")
val txVerCuenta = mutableStateOf("0")
var valor: MutableList<String> = mutableListOf()
val txVerResultado = mutableStateOf("[    ]")
val txResultado = mutableStateOf("")



val valor1 = mutableStateOf(0)
val valor2 = mutableStateOf(0)
val operacion = mutableStateOf<Signos?>(null)




@Composable
fun Boton(tx: String, modifier: Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(
                PurpleBlue,
                shape = CircleShape
            )
            .clickable {

                onClick(tx)

            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = tx,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = Color.White
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun AppView() {
    when (LocalConfiguration.current.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            Column(
                Modifier
                    .background(Color.Black)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Contenido(modifier = Modifier.weight(0.50F))
            }
        }
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row(
                Modifier
                    .background(Color.Black)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Contenido(modifier = Modifier.weight(0.50F))
            }
        }
        else -> throw RuntimeException()
    }

}

@Composable
fun Contenido(modifier: Modifier) {
    Box(
        modifier
            .fillMaxWidth()

            .background(Color.Black)
    ) {
        Column {
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(0.66F), contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = txVerCuenta.value, fontSize = 40.sp, color = Color.White
                )
            }
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(0.33F), contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = txVerResultado.value, fontSize = 40.sp, color = Color.White
                )
            }
        }
    }

    Row(
        modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .weight(0.75F), verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {

            Row(
                Modifier
                    .background(Color.Black)
                    .weight(0.16F)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Boton(tx = "÷", modifier = Modifier.weight(0.33F))
                Boton(tx = "×", modifier = Modifier.weight(0.33F))
                Boton(tx = "-", modifier = Modifier.weight(0.33F))

            }
            Row(
                Modifier
                    .background(Color.Black)
                    .weight(0.16F)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)

            ) {
                Boton(tx = "7", modifier = Modifier.weight(0.33F))
                Boton(tx = "8", modifier = Modifier.weight(0.33F))
                Boton(tx = "9", modifier = Modifier.weight(0.33F))

            }
            Row(
                Modifier
                    .background(Color.Black)
                    .weight(0.16F)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Boton(tx = "4", modifier = Modifier.weight(0.33F))
                Boton(tx = "5", modifier = Modifier.weight(0.33F))
                Boton(tx = "6", modifier = Modifier.weight(0.33F))
            }
            Row(
                Modifier
                    .background(Color.Black)
                    .weight(0.16F)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Boton(tx = "1", modifier = Modifier.weight(0.33F))
                Boton(tx = "2", modifier = Modifier.weight(0.33F))
                Boton(tx = "3", modifier = Modifier.weight(0.33F))
            }
            Row(
                Modifier
                    .background(Color.Black)
                    .weight(0.16F)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Boton(tx = "0", modifier = Modifier.weight(0.66F))
                Boton(tx = ".", modifier = Modifier.weight(0.33F))

            }
        }
        Column(
            Modifier
                .background(Color.Black)
                .fillMaxHeight()
                .fillMaxWidth()
                .weight(0.25F), verticalArrangement = Arrangement.spacedBy(5.dp)

        ) {

            Boton(tx = "+", modifier = Modifier.weight(0.16F))
            Boton(tx = "C", modifier = Modifier.weight(0.16F))
            Boton(tx = "CE", modifier = Modifier.weight(0.16F))
            Boton(tx = "=", modifier = Modifier.weight(0.3333F))
        }

    }
}

