public class NewpetFragment extends Fragment {
	Spinner spiSpSpecies;
	com.google.android.material.textfield.TextInputEditText tietEtClLastname;
	Spinner spiSpGender;
	com.google.android.material.textfield.TextInputEditText tietEtPetDatebirth;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_newpet, container, false);
		spiSpSpecies	= findViewById(R.id.sp_species);
		tietEtClLastname	= findViewById(R.id.et_cl_lastname);
		spiSpGender	= findViewById(R.id.sp_gender);
		tietEtPetDatebirth	= findViewById(R.id.et_pet_datebirth);
	}
}
