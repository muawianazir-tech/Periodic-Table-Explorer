package com.example.periodictable;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Fragment_filter extends DialogFragment {

    public interface FilterListener {
        void onFilterApplied(String category, String block);
    }

    private FilterListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (FilterListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement FilterListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_filter, null);

        RadioGroup stateGroup = view.findViewById(R.id.filter_radio_group);
        RadioGroup blockGroup = view.findViewById(R.id.filter_block_group);
        Button btnApply = view.findViewById(R.id.btn_apply_filter);

        btnApply.setOnClickListener(v -> {

            int stateId = stateGroup.getCheckedRadioButtonId();
            String category = "All";
            if (stateId == R.id.rb_solid) category = "Solid";
            else if (stateId == R.id.rb_liquid) category = "Liquid";
            else if (stateId == R.id.rb_gas) category = "Gas";

            int blockId = blockGroup.getCheckedRadioButtonId();
            String block = "All";
            if (blockId == R.id.rb_block_s) block = "s-block";
            else if (blockId == R.id.rb_block_p) block = "p-block";
            else if (blockId == R.id.rb_block_d) block = "d-block";
            else if (blockId == R.id.rb_block_f) block = "f-block";

            listener.onFilterApplied(category, block);
            dismiss();
        });

        builder.setView(view);
        return builder.create();
    }
}