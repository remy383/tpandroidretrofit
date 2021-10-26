package fr.m2i.android.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import fr.m2i.android.testapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private TextView paysView;
    private TextView villeView;
    private TextView formationView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GsonSingleton.getInstance().setDescriptionValues();
        Description description = GsonSingleton.getInstance().getDescription();
        paysView = getView().findViewById(R.id.paysView);
        villeView = getView().findViewById(R.id.villeView);
        formationView = getView().findViewById(R.id.formationView);

        paysView.setText(description.getPays());
        villeView.setText(description.getVille());
        formationView.setText(description.getFormation());

        binding.buttonSecond.setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}