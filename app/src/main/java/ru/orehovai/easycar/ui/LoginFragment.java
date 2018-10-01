package ru.orehovai.easycar.ui;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;
import ru.orehovai.easycar.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment//.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.tvWelcome)
    TextView tvWelcome;
    @BindView(R.id.textInputLayoutEmail)
    TextInputLayout textInputLayoutEmail;
    @BindView(R.id.textInputLayoutPassword)
    TextInputLayout textInputLayoutPassword;
    @BindView(R.id.textInputLayoutConfirmPassword)
    TextInputLayout textInputLayoutConfirmPassword;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;
    @BindView(R.id.tvLostPassword)
    TextView tvLostPassword;
    @BindView(R.id.btnNext)
    Button btnNext;
    @BindView(R.id.vg_oferta)
    ViewGroup vgOferta;
    @BindView(R.id.iv_info)
    ImageView ivInfo;
    @BindView(R.id.tv_oferta_agree)
    TextView tvOfertaAgree;
    @BindView(R.id.sw_oferta)
    SwitchCompat swOferta;

    private Unbinder unbinder;

    private boolean accountEnabled;

    public boolean isAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    //private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        accountEnabled = false;//при загрузке фрагмента
//        if (context instanceof OnFragmentInteractionListener) {
//            //mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    @OnTextChanged(R.id.etEmail)
    void onEmailTextChange() {
        etPassword.setText("");
        btnNext.setVisibility(View.GONE);
        swOferta.setChecked(false);
        if (Patterns.EMAIL_ADDRESS.matcher(etEmail.getText()).matches()) {
            if (etEmail.getText().toString().equals("test@test.ru")) {

                setAccountEnabled(true);

                textInputLayoutEmail.setErrorTextAppearance(R.style.ErrorTextSuccess);
                textInputLayoutEmail.setHintTextAppearance(R.style.ErrorTextSuccess);
                textInputLayoutEmail.setError("Email correct!");
                textInputLayoutConfirmPassword.setVisibility(View.GONE);
                tvLostPassword.setVisibility(View.VISIBLE);
            } else {

                setAccountEnabled(false);

                textInputLayoutEmail.setErrorTextAppearance(R.style.ErrorText);
                textInputLayoutEmail.setHintTextAppearance(R.style.ErrorText);
                textInputLayoutEmail.setError("email not registered");
                textInputLayoutPassword.setVisibility(View.VISIBLE);
                textInputLayoutConfirmPassword.setVisibility(View.VISIBLE);
                tvLostPassword.setVisibility(View.GONE);
            }

        } else {

            setAccountEnabled(false);

            textInputLayoutEmail.setErrorTextAppearance(R.style.ErrorText);
            textInputLayoutEmail.setHintTextAppearance(R.style.ErrorText);
            textInputLayoutEmail.setError("");
            textInputLayoutPassword.setVisibility(View.GONE);
            tvLostPassword.setVisibility(View.GONE);
            textInputLayoutConfirmPassword.setVisibility(View.GONE);
        }
    }

    @OnTextChanged(R.id.etPassword)
    void onPasswordTextChange() {
        etConfirmPassword.setText("");
        if (!TextUtils.isEmpty(etPassword.getText())) {
            if (etPassword.getText().length() < 8 ) {
                textInputLayoutPassword.setError("Не меньше 8 символов");
                vgOferta.setVisibility(View.GONE);
            } else {
                textInputLayoutPassword.setError("");
                if (textInputLayoutConfirmPassword.getVisibility() == View.GONE) {
                    vgOferta.setVisibility(View.VISIBLE);
                } else vgOferta.setVisibility(View.GONE);
            }

        }
    }

    @OnTextChanged(R.id.etConfirmPassword)
    void  onConfirmPasswordTextChange() {
        textInputLayoutEmail.setError("");
        vgOferta.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(etConfirmPassword.getText())) {
            if (etConfirmPassword.getText().length() < 8) {
                textInputLayoutConfirmPassword.setError("Не меньше 8 символов");
            } else if (!(etConfirmPassword.getText().toString().equals(etPassword.getText().toString()))) {
                textInputLayoutConfirmPassword.setError("Пароли не совпадают");
            } else {
                textInputLayoutConfirmPassword.setError("");
                vgOferta.setVisibility(View.VISIBLE);
            }
        }
    }

    @OnCheckedChanged(R.id.sw_oferta)
    void onSwOfertaCheck() {
        if (swOferta.isChecked()){
            if (isAccountEnabled()){
                btnNext.setText("Далее");
            } else {
                btnNext.setText("Регистрация");
                textInputLayoutConfirmPassword.setError("");
            }
            btnNext.setVisibility(View.VISIBLE);
        } else btnNext.setVisibility(View.GONE);

    }

    @OnClick(R.id.btnNext)
    void onClickNext() {
        if (isAccountEnabled()){

        }
    }
}
