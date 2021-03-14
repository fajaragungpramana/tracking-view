# Android TrackingView
[![](https://jitpack.io/v/fajaragungpramana/tracking-view.svg)](https://jitpack.io/#fajaragungpramana/tracking-view)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
</br>
</br>
Library for android. Tracking view is used to display tracking step.

## Installation
Add it in your root build.gradle at the end of repositories:
```gradle
allProjects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency:
```gradle
dependencies {
	implementation 'com.github.fajaragungpramana:tracking-view:0.0.1'
}
```

## Usage
First step, create your layout recycler view adapter inside there is a `TrackingView` component. For example i create `destination_adapter.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginHorizontal="16dp">

    <com.github.fajaragungpramana.trackingview.TrackingView
        android:id="@+id/tkv_destination"
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        app:dashed="false"
        app:indicatorColor="@color/purple_500"
        app:indicatorSize="16dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:lineWidth="2dp" />

    <TextView
        android:id="@+id/tv_pos"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:textColor="@color/black"
        android:textSize="14sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toEndOf="@+id/tkv_destination"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0"
        tools:text="Pos A" />

    <TextView
        android:id="@+id/tv_address"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"
        android:textSize="12sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="@+id/tv_pos"
        app:layout_constraintTop_toBottomOf="@+id/tv_pos"
        tools:text="is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

and in your adapter class call method `set(position, itemCount)` from `TrackingView` object. fill the method parameter with your adapter position and item data size
```kotlin
class DestinationAdapter(private val mListDestination: List<Destination>) :
    RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    override fun getItemCount() = mListDestination.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindDestination(mListDestination[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_destination, parent, false)
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mTrackingView by lazy { view.findViewById<TrackingView>(R.id.tkv_destination) }

        private val mPos by lazy { view.findViewById<TextView>(R.id.tv_pos) }
        private val mAddress by lazy { view.findViewById<TextView>(R.id.tv_address) }

        fun bindDestination(destination: Destination) {
            mPos.text = destination.pos
            mAddress.text = destination.address

            mTrackingView.set(adapterPosition, itemCount)
        }

    }

}
```

## Documentation
Attribute for TrackingView
| Attribute Name | Default Value | Description |
|----------------|---------------|-------------|
| dashed | #false | To set dashed line destination |
| lineWidth | 2dp | Size of line width |
| indicatorColor | #FF0000 | Set the tracking view color |
| indicatorSize | 16dp | Set the circle indicator size |

## Preview
</br>
</br>
<a href="url"><img src="https://github.com/fajaragungpramana/assets/blob/master/TrackingView/TrackingView.jpg" align="left" height="640" width="320" ></a>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

## License
Copyright 2021 Fajar Agung Pramana

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
