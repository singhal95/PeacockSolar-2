package com.example.architgoyal.peacocksolar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class InstallationAddressFragment extends Fragment {

    private EditText inputAddress1, inputAddress2, inputPincode;
    private TextInputLayout inputLayoutAddress1, inputLayoutAddress2, inputLayoutPincode;
    private Button btnNext, btnBack, btnLocate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_installation_address, container, false);
        inputLayoutAddress1 = (TextInputLayout) view.findViewById(R.id.input_layout_address1);
        inputLayoutAddress2 = (TextInputLayout) view.findViewById(R.id.input_layout_address2);
        inputLayoutPincode = (TextInputLayout) view.findViewById(R.id.input_layout_pincode);
        inputAddress1 = (EditText) view.findViewById(R.id.input_address1);
        inputAddress2 = (EditText) view.findViewById(R.id.input_address2);
        inputPincode = (EditText) view.findViewById(R.id.input_pincode);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnBack = (Button) view.findViewById(R.id.btn_back);
        btnLocate = (Button) view.findViewById(R.id.btn_locate_me);

        inputAddress1.addTextChangedListener(new MyTextWatcher(inputAddress1));
        inputAddress2.addTextChangedListener(new MyTextWatcher(inputAddress2));
        inputPincode.addTextChangedListener(new MyTextWatcher(inputPincode));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        btnLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locateMe();
            }
        });
        return view;
    }

    private void submitForm() {
        if (!validateAddress1()) {
            return;
        }

        if (!validateAddress2()) {
            return;
        }

        if (!validatePincode()) {
            return;
        }
        ((SignUpActivity)getActivity()).setCurrentItem (2, true);
    }

    private boolean validateAddress1() {
        if (inputAddress1.getText().toString().trim().isEmpty()) {
            inputLayoutAddress1.setError(getString(R.string.err_msg_));
            return false;
        } else {
            inputLayoutAddress1.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAddress2() {
        String address2 = inputAddress2.getText().toString().trim();

        if (address2.isEmpty()) {
            inputLayoutAddress2.setError(getString(R.string.err_msg_address2));
            return false;
        } else {
            inputLayoutAddress2.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePincode() {
        if (inputPincode.getText().toString().trim().isEmpty()) {
            inputLayoutPincode.setError(getString(R.string.err_msg_pincode));
            return false;
        } else {
            inputLayoutPincode.setErrorEnabled(false);
        }

        return true;
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_address1:
                    validateAddress1();
                    break;
                case R.id.input_address2:
                    validateAddress2();
                    break;
                case R.id.input_pincode:
                    validatePincode();
                    break;
            }
        }
    }

    private void back(){
        ((SignUpActivity)getActivity()).setCurrentItem (0, true);
    }

    private void locateMe(){

    }
}
