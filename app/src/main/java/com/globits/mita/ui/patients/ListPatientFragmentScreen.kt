package com.globits.mita.ui.patients

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.globits.mita.R
import com.globits.mita.ui.home.SetLayoutSearch
import com.globits.mita.ui.theme.*
import java.util.*


@Preview
@Composable
fun DefaultPreviewListPatient() {
    SetLayoutListPatientFragment() {

    }
}

@Composable
fun SetLayoutListPatientFragment(onClickListener: (PatientInfo) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
    ) {
        SetHeaderListPatient()
        SetBodyListPatient(onClickListener)
    }
}

@Composable
fun SetHeaderListPatient() {
    Column {
        SetLayoutSearch(title = "Tìm kiếm bệnh nhân") {
        }
        var valueState by remember {
            mutableStateOf("")
        }
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SetLayoutRadioButton(title = "Đang điều trị", valueState) {
                    valueState = it
                }
                SetLayoutRadioButton(title = "Xem tất cả", valueState) {
                    valueState = it
                }

            }
        }
    }
}

@Composable
fun SetLayoutRadioButton(title: String, valueState: String, onClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 16.dp)
    ) {
        RadioButton(
            selected = valueState == title,
            onClick = {
                onClick(title)
            },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Magenta
            )
        )
        Text(text = title)
    }
}


@Composable
fun SetBodyListPatient(onClickListener: (PatientInfo) -> Unit) {
    val listPatientInfo by remember {
        mutableStateOf(mutableListOf<PatientInfo>(PatientInfo(), PatientInfo()))
    }
    LazyColumn(content = {
        items(listPatientInfo) { item ->
            SetLayoutItemPatient(patient = item) {
                onClickListener(item)
            }
        }
    })
}

@Composable
fun SetLayoutItemPatient(patient: PatientInfo, onClickPatient: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp, top = 4.dp)
            .clickable { onClickPatient() },
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            SetLayoutPatientInfoItem()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_location_patient),
                    modifier = Modifier
                        .width(10.dp)
                        .height(10.dp)
                        .clickable {
                            println("icon click")
                        }, contentDescription = "", tint = ICON_LOCATION

                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "P. Vạn Mỹ, Q. Ngô Quyền, Hải Phòng",
                    style = styleText
                )
            }
        }


    }
}

