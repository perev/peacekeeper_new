package hiof.android14.group26.peacekeeper.slidingMenu;

import android.support.v4.app.Fragment;
import hiof.android14.group26.peacekeeper.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FinancialsFragment extends Fragment {
	
	public FinancialsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		View rootView = inflater.inflate(R.layout.financials, container, false);
         
        return rootView;
    }
}
