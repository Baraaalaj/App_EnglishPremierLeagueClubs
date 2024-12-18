package com.example.app_englishpremierleagueclubs.Model

import android.os.Parcel
import android.os.Parcelable

data class SoccerTile(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val descriptionLong: String = "",
    val buttonText: String = "",
    val headerImageResId: Int = 0,
    val headerImageURL: String? = "",
    val teamUrl: String = "",
    var isFavorite: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString(),
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(descriptionLong)
        parcel.writeString(buttonText)
        parcel.writeInt(headerImageResId)
        parcel.writeString(headerImageURL)
        parcel.writeString(teamUrl)
        parcel.writeByte(if (isFavorite) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<SoccerTile> {
        override fun createFromParcel(parcel: Parcel): SoccerTile {
            return SoccerTile(parcel)
        }

        override fun newArray(size: Int): Array<SoccerTile?> {
            return arrayOfNulls(size)
        }
    }
}
