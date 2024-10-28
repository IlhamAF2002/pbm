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
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
fun Quiz(modifier: Modifier = Modifier) {
    var quizNumber by remember { mutableStateOf( 1) }
    val answer = when(quizNumber) {
        1 -> ""
        2 -> "france   "
        3 -> "canada   "
        4 -> "australia"
        else -> "germany  "
    }
    val flag = when(quizNumber) {
        1 -> R.drawable.france
        2 -> R.drawable.canada
        3 -> R.drawable.australia
        else -> R.drawable.germany
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(flag), contentDescription = quizNumber.toString())
        Card(modifier = Modifier) {
            Text(text = answer, fontSize = 24.sp)
        }

        Button(
            onClick = { quizNumber +=1 },
        ) {
            Text(text = stringResource(R.string.australia), fontSize = 24.sp)
        }
        Button(
            onClick = { quizNumber +=1 },
        ) {
            Text(text = stringResource(R.string.canada), fontSize = 24.sp)
        }
        Button(
            onClick = { quizNumber +=1 },
        ) {
            Text(text = stringResource(R.string.france), fontSize = 24.sp)
        }
        Button(
            onClick = { quizNumber +=1 },
        ) {
            Text(text = stringResource(R.string.germany), fontSize = 24.sp)
        }
    }
}
