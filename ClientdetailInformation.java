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
		vpVppets	= findViewById(R.id.vppets);
		ciVpindicator	= findViewById(R.id.vpindicator);
		tvContactAddress1	= findViewById(R.id.contact_address1);
		tvContactCitypostcode	= findViewById(R.id.contact_citypostcode);
		tvContactHomephone	= findViewById(R.id.contact_homephone);
		ibContactHomephoneCall	= findViewById(R.id.contact_homephone_call);
		tvContactWorkphone	= findViewById(R.id.contact_workphone);
		ibContactWorkphoneCall	= findViewById(R.id.contact_workphone_call);
		tvContactCellphonecall	= findViewById(R.id.contact_cellphonecall);
		ibContactCellphoneCall	= findViewById(R.id.contact_cellphone_call);
		tvContactCellphonesms	= findViewById(R.id.contact_cellphonesms);
		tvContactEmail	= findViewById(R.id.contact_email);
	}
}
