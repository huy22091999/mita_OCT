package com.globits.mita.ui.patients

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globits.mita.R
import com.globits.mita.ui.theme.*

@Preview
@Composable
fun DefaultPreviewPatientInfo() {
    SetLayoutPatientInfo()
}
@Composable
fun SetLayoutPatientInfoPacs() {
    Column(
        Modifier
            .background(Color.White)
    ) {
        SetUpToolbarLayout()
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Box {
                Row(
                    Modifier
                        .background(BACKGROUND_TOOLBAR)
                        .fillMaxWidth()
                        .height(92.dp)
                ) {}
                Column(Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp)) {
                    SetLayoutItemPatient(patient = PatientInfo()) {
                    }
                }
            }
            //SetLayoutDiagnostic()
            SetUpListFeatureLayout()
        }
    }
}

@Composable
fun SetLayoutPatientInfo() {
    Column(
        Modifier
            .background(Color.White)
    ) {
        SetUpToolbarLayout()
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Box {
                Row(
                    Modifier
                        .background(BACKGROUND_TOOLBAR)
                        .fillMaxWidth()
                        .height(92.dp)
                ) {}
                Column(Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp)) {
                    SetLayoutItemPatient(patient = PatientInfo()) {
                    }
                }
            }
            SetLayoutDiagnostic()
            SetUpListFeatureLayout()
        }


    }
}
@Composable
fun SetLayoutDiagnostic(){
    Column(Modifier.padding(start = 24.dp, end = 16.dp)) {
        Text(
            text = "Chu???n ??o??n", fontSize = 17.sp,
            color = TEXT_BACK,
            style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_bold)))
        )
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = "A10 - ??au b???ng ch??a r?? nguy??n nh??n; J11 - T??ng huy???t ??p v?? c??n",
            fontSize = 14.sp,
            color = TEXT_DOB,
            style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
        )
    }
}

@Composable
fun SetUpListFeatureLayout() {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 12.dp)
            .fillMaxWidth()
    ) {
        SetUpItemFeatureLayout(title = "B???nh ??n")
        SetUpItemFeatureLayout(title = "Ghi ch??")
        SetUpItemFeatureLayout(title = "T??? ??i???u tr???")
        SetUpItemFeatureLayout(title = "Ch??? ?????nh DVKT")
        SetUpItemFeatureLayout(title = "K?? ????n")
        SetUpItemFeatureLayout(title = "C??ng n???")
        SetUpItemFeatureLayout(title = "PACS")

    }
}

@Composable
fun SetUpItemFeatureLayout(title: String) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Row(
            modifier = Modifier
                .border(
                    border = BorderStroke(1.dp, STROKE_BTN_FEATURE),
                    shape = RoundedCornerShape(12.dp)
                )
                .fillMaxWidth()
                .padding()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title, fontSize = 16.sp,
                color = PRIMARY_COLOR,
                style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_bold)))
            )
            IconButton(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "Menu Btn", tint = PRIMARY_COLOR,
                )
            }
        }
    }
}

@Composable
fun SetUpToolbarLayout() {
    TopAppBar(
        title = {
            Text(
                text = "Th??ng tin b???nh nh??n",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        },
        actions = {
            IconButton(
                onClick = { }, Modifier
                    .background(
                        shape = RoundedCornerShape(12.dp),
                        color = BACKGROUND_TOOLBAR
                    )
                    .height(44.dp)
                    .width(44.dp)
                    .border(
                        border = BorderStroke(1.dp, STROKE_COLOR),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_link),
                    contentDescription = "Menu Btn",
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = { }, Modifier
                    .background(
                        shape = RoundedCornerShape(12.dp),
                        color = BACKGROUND_TOOLBAR
                    )
                    .height(44.dp)
                    .width(44.dp)
                    .border(
                        border = BorderStroke(1.dp, STROKE_COLOR),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Menu Btn",
                )
            }
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        elevation = 0.dp,
        modifier = Modifier
            .background(BACKGROUND_TOOLBAR)
            .padding(start = 16.dp, end = 16.dp)
    )
}
