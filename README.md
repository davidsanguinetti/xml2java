# xml2java
group and generates all the id in a XML to java variables, ready to use

# This project is deprecated
Yet it was very useful at the time; now just go an learn Kotlin and Jetpack ;-)

# Description
When you create a layout full of ids, and then you needed to replicate them in .java file?
Just run 

`java 'jar xml2java.jar newlayout.xml`
and a .java file is instanly created, for activity or fragment with all the fields of the layou, ready to be used.


```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <androidx.viewpager.widget.ViewPager
        android:id="@+id/vppets"
        android:layout_width="match_parent"
        android:layout_height="170dp" />
    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        android:padding="15dp"
        >
    <me.relex.circleindicator.CircleIndicator
        android:id="@+id/vpindicator"
        android:layout_width="wrap_content"
        android:layout_height="15dp"
        android:layout_centerInParent="true"
        />
    </RelativeLayout>
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="vertical"
        android:fadeScrollbars="false"
        >

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:padding="20dp"
            android:background="@color/colorPrimary"
            >

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Address"
                android:textAllCaps="true"
                android:textColor="@color/lightGrayBkg"
                android:textSize="10dp" />

            <TextView
                android:id="@+id/contact_address1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="-"
                android:textColor="@color/mdtp_white"
                android:textIsSelectable="true" />

            <TextView
                android:id="@+id/contact_citypostcode"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="-"
                android:textColor="@color/mdtp_white"
                android:textIsSelectable="true" />
<!-- etc. -->
```

`~/$ java 'jar xml2java.jar newlayout.xml`


```java
package
public class ClientdetailInformationFragment extends Fragment {
	androidx.viewpager.widget.ViewPager vpVppets;
	me.relex.circleindicator.CircleIndicator ciVpindicator;
	TextView tvContactAddress1;
	TextView tvContactCitypostcode;
	TextView tvContactHomephone;
	ImageButton ibContactHomephoneCall;
	TextView tvContactWorkphone;
	ImageButton ibContactWorkphoneCall;
	TextView tvContactCellphonecall;
	ImageButton ibContactCellphoneCall;
	TextView tvContactCellphonesms;
	TextView tvContactEmail;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_clientdetail_information, container, false);
		vpVppets	= v.findViewById(R.id.vppets);
		ciVpindicator	= v.findViewById(R.id.vpindicator);
		tvContactAddress1	= v.findViewById(R.id.contact_address1);
		tvContactCitypostcode	= v.findViewById(R.id.contact_citypostcode);
		tvContactHomephone	= v.findViewById(R.id.contact_homephone);
		ibContactHomephoneCall	= v.findViewById(R.id.contact_homephone_call);
		tvContactWorkphone	= v.findViewById(R.id.contact_workphone);
		ibContactWorkphoneCall	= v.findViewById(R.id.contact_workphone_call);
		tvContactCellphonecall	= v.findViewById(R.id.contact_cellphonecall);
		ibContactCellphoneCall	= v.findViewById(R.id.contact_cellphone_call);
		tvContactCellphonesms	= v.findViewById(R.id.contact_cellphonesms);
		tvContactEmail	= v.findViewById(R.id.contact_email);
	}
}
