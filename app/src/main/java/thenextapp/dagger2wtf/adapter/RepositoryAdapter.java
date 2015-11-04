package thenextapp.dagger2wtf.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import thenextapp.dagger2wtf.R;
import thenextapp.dagger2wtf.models.Repository;

/**
 * Created by Sandy on 11/4/15.
 */
public class RepositoryAdapter extends BaseAdapter{

    private Activity mActivity;
    private LayoutInflater mInflater;
    private List<Repository> mRepositoryList;

    public RepositoryAdapter(Activity activity, List<Repository> repositoryList) {
        mActivity = activity;
        mRepositoryList = repositoryList;
        mInflater = LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return mRepositoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return mRepositoryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolderItem {
        @InjectView(R.id.name)
        TextView tvName;

        @InjectView(R.id.forks_count)
        TextView tvForksCount;

        @InjectView(R.id.watchers)
        TextView tvWatchers;

        @InjectView(R.id.open_issues)
        TextView tvOpenIssues;

        public ViewHolderItem(View view) {
            ButterKnife.inject(this, view);
        }
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder = null;

        if (convertView==null) {
            convertView = mInflater.inflate(R.layout.adapter_repository, parent, false);
            viewHolder = new ViewHolderItem(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        viewHolder.tvName.setText(mRepositoryList.get(pos).name);
        viewHolder.tvForksCount.setText("Forks count : " + mRepositoryList.get(pos).forks_count);
        viewHolder.tvWatchers.setText("Watchers : " + mRepositoryList.get(pos).watchers);
        viewHolder.tvOpenIssues.setText("Open Issues : " + mRepositoryList.get(pos).open_issues);

        return convertView;
    }
}
