package momoluc.study_samples.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import momoluc.study_samples.R
import momoluc.study_samples.ui.theme.Purple500
import momoluc.study_samples.ui.theme.Teal200

@Composable
fun HorizontalCard() {
    Surface(Modifier.padding(5.dp), shape = RoundedCornerShape(15.dp), elevation = 4.dp) {
        Row {
            Box(
                Modifier
                    .height(200.dp)
                    .width(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = null,
                    Modifier
                        .size(100.dp)
                        .offset(x = 50.dp)
                        .clip(shape = CircleShape)
                        .align(Alignment.CenterEnd)
                        .border(2.2.dp, Purple500, CircleShape)
                )
            }
            Spacer(
                modifier = Modifier.width(50.dp)
            )
            Box(
                Modifier
                    .height(200.dp)
                    .width(250.dp)
            ) {
                Text(
                    text = LoremIpsum(40).values.first(),
                    Modifier
                        .align(Alignment.Center)
                        .padding(end = 10.dp, start = 10.dp),
                    fontWeight = FontWeight(400),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun HorizontalCardPreview() {
    HorizontalCard()
}