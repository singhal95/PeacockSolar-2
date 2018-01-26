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


public class BillInfoFragment extends Fragment {

    private EditText inputDimensions, inputBill1, inputBill2;
    private TextInputLayout inputLayoutDimensions, inputLayoutBill1, inputLayoutBill2;
    private Button btnSignUp, btnBack, btnRooftopImage, btnBill1, btnBill2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bill_info, container, false);
        inputLayoutDimensions = (TextInputLayout) view.findViewById(R.id.input_layout_rooftop_dimensions);
        inputLayoutBill1 = (TextInputLayout) view.findViewById(R.id.input_layout_bill1);
        inputLayoutBill2 = (TextInputLayout) view.findViewById(R.id.input_layout_bill2);
        inputDimensions = (EditText) view.findViewById(R.id.input_rooftop_dimensions);
        inputBill1 = (EditText) view.findViewById(R.id.input_bill1);
        inputBill2 = (EditText) view.findViewById(R.id.input_bill2);
        btnSignUp = (Button) view.findViewById(R.id.btn_sign_up);
        btnBack = (Button) view.findViewById(R.id.btn_back);
        btnBill1 = (Button) view.findViewById(R.id.btn_bill1);
        btnBill2 = (Button) view.findViewById(R.id.btn_bill2);
        btnRooftopImage = (Button) view.findViewById(R.id.btn_rooftop_image);

        inputDimensions.addTextChangedListener(new MyTextWatcher(inputDimensions));
        inputBill1.addTextChangedListener(new MyTextWatcher(inputBill1));
        inputBill2.addTextChangedListener(new MyTextWatcher(inputBill2));

        btnSignUp.setOnClickListener(new View.OnClickListener() {
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
        btnRooftopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rooftopImage();
            }
        });
        btnBill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bill1Image();
            }
        });
        btnBill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bill2Image();
            }
        });
        return view;
    }

    private void submitForm() {
        if (!validateDimensions()) {
            return;
        }

        if (!validateBill1()) {
            return;
        }

        if (!validateBill2()) {
            return;
        }
    }

    private boolean validateDimensions() {
        if (inputDimensions.getText().toString().trim().isEmpty()) {
            inputLayoutDimensions.setError(getString(R.string.err_msg_rooftop_dimensions));
            return false;
        } else {
            inputLayoutDimensions.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateBill1() {
        String address2 = inputBill1.getText().toString().trim();

        if (address2.isEmpty()) {
            inputLayoutBill1.setError(getString(R.string.err_msg_bill1));
            return false;
        } else {
            inputLayoutBill1.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateBill2() {
        if (inputBill2.getText().toString().trim().isEmpty()) {
            inputLayoutBill2.setError(getString(R.string.err_msg_bill2));
            return false;
        } else {
            inputLayoutBill2.setErrorEnabled(false);
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
                case R.id.input_rooftop_dimensions:
                    validateDimensions();
                    break;
                case R.id.input_bill1:
                    validateBill1();
                    break;
                case R.id.input_bill2:
                    validateBill2();
                    break;
            }
        }
    }

    private void back(){
        ((SignUpActivity)getActivity()).setCurrentItem (1, true);
    }

    private void rooftopImage(){

    }

    private void bill1Image(){

    }

    private void bill2Image(){

    }
}
