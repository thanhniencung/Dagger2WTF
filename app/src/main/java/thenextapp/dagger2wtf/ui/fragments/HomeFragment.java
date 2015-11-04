package thenextapp.dagger2wtf.ui.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import thenextapp.dagger2wtf.GithubApplication;
import thenextapp.dagger2wtf.R;
import thenextapp.dagger2wtf.adapter.RepositoryAdapter;
import thenextapp.dagger2wtf.api.GithubApi;
import thenextapp.dagger2wtf.models.Repository;

public class HomeFragment extends Fragment {

    @Inject
    GithubApi gitApi;

    @InjectView(R.id.listview)
    ListView mListView;

    @InjectView(R.id.progress)
    ProgressBar mProgressBar;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GithubApplication.component().inject(this);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gitApi.getAllRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Repository>>() {
                    @Override
                    public void call(List<Repository> repositories) {
                       if (repositories != null) {
                           mProgressBar.setVisibility(View.INVISIBLE);
                           RepositoryAdapter adapter = new RepositoryAdapter(getActivity(), repositories);
                           mListView.setAdapter(adapter);
                       }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }
}
