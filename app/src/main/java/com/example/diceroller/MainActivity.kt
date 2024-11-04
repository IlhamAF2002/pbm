/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.diceroller

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background //penggunaan matrial theme
                ) {
                    FlagQuizApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun FlagQuizApp() {
    Quiz(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun Quiz(modifier: Modifier = Modifier) { //fungsi utama
    var quizNumber by remember { mutableStateOf( 1) }
    val answer = when(quizNumber) {//val answer akan diisi teks yang menunjukkan jawaban dari pertanyaan sebelumnya
        1 -> ""
        2 -> "the answer is france"
        3 -> "the answer is canada"
        4 -> "the answer is australia"
        else -> "the answer is germany"
    }
    val flag = when(quizNumber) {//val flag akan mengambil gambar bendera di app/src/main/res/drawable app/src/main/res/drawable-v24 berdasarkan nilai var quizNumber
        1 -> R.drawable.france
        2 -> R.drawable.canada
        3 -> R.drawable.australia
        else -> R.drawable.germany
    }
//ui tersersusun secara vertikal menggunakan column()
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally,) {
        Image(painter = painterResource(flag), contentDescription = quizNumber.toString()) //digunakan untuk menampilkan val flag

        Card(modifier = Modifier //digunakan untuk menampilkan val answer
            .padding(4.dp), // menambah sspace koseng smengelilingi card
            ) {
            Text(text = answer,modifier = Modifier.padding(4.dp), textAlign = TextAlign.Center, fontSize = 24.sp)
        }
        Button(modifier = Modifier //4 button sebagai pilihan ganda
            .fillMaxWidth() //lebar button akan mengikuti lebar maksimal device
            .padding(4.dp),
            onClick = { quizNumber +=1 }, //jika ditekan nilai var quizNumber akan ditambah 1 sehingga gambar bendera akan berubah ke gambar yang selanjutnya
        ) {
            Text(text = stringResource(R.string.australia), fontSize = 24.sp) //menampilkan text yang telah didefinisikan di app/src/main/res/values/colors.xml
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
            onClick = { quizNumber +=1 },
        ) {
            Text(text = stringResource(R.string.canada), fontSize = 24.sp)
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
            onClick = { quizNumber +=1 },
        ) {
            Text(text = stringResource(R.string.france), fontSize = 24.sp)
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
            onClick = { quizNumber +=1 },
        ) {
            Text(text = stringResource(R.string.germany), fontSize = 24.sp)
        }
    }
}
