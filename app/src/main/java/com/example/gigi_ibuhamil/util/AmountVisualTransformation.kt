package com.example.gigi_ibuhamil.util

import android.text.TextUtils.isDigitsOnly
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.core.text.isDigitsOnly
import java.text.DecimalFormat

class AmountOrMessageVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            text = AnnotatedString(formatAmountOrMessage(text.text)),
            offsetMapping = OffsetMapping.Identity
        )
    }
}
val String.isValidFormattableAmount get(): Boolean = isNotBlank() && isDigitsOnly() && length <= 4

fun formatAmountOrMessage(
    input: String
): String = if (input.isValidFormattableAmount) {
    DecimalFormat("#,##").format(input.toDouble())
} else {
    input
}