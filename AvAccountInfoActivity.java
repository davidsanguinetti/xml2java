package
public class AvAccountInfoActivity extends AppCompatActivity {
	androidx.appcompat.widget.Toolbar andAccinfoToolbar;
	ProgressBar pbAccinfoProgress;
	TextView tvAccinfoTitlenr;
	TextView tvAccinfoTitlename;
	TextView tvAccinfoNr;
	TextView tvAccinfoName;
	TextView tvAccinfoEmail;
	TextView tvAccinfoAddress;
	TextView tvAccinfoCity;
	TextView tvAccinfoPhone;
	TextView tvAccinfoOlsAuth;
	TextView tvAccinfoOlsMode;
	TextView tvAccinfoOlsDelsupport;
	TextView tvAccinfoStatusEmail;
	TextView tvAccinfoStatusText;
	TextView tvAccinfoStatusPhone;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_av_account_info);
		andAccinfoToolbar	= findViewById(R.id.accinfo_toolbar);
		pbAccinfoProgress	= findViewById(R.id.accinfo_progress);
		tvAccinfoTitlenr	= findViewById(R.id.accinfo_titlenr);
		tvAccinfoTitlename	= findViewById(R.id.accinfo_titlename);
		tvAccinfoNr	= findViewById(R.id.accinfo_nr);
		tvAccinfoName	= findViewById(R.id.accinfo_name);
		tvAccinfoEmail	= findViewById(R.id.accinfo_email);
		tvAccinfoAddress	= findViewById(R.id.accinfo_address);
		tvAccinfoCity	= findViewById(R.id.accinfo_city);
		tvAccinfoPhone	= findViewById(R.id.accinfo_phone);
		tvAccinfoOlsAuth	= findViewById(R.id.accinfo_ols_auth);
		tvAccinfoOlsMode	= findViewById(R.id.accinfo_ols_mode);
		tvAccinfoOlsDelsupport	= findViewById(R.id.accinfo_ols_delsupport);
		tvAccinfoStatusEmail	= findViewById(R.id.accinfo_status_email);
		tvAccinfoStatusText	= findViewById(R.id.accinfo_status_text);
		tvAccinfoStatusPhone	= findViewById(R.id.accinfo_status_phone);
}
}
