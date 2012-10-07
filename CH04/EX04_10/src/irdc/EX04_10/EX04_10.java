package irdc.EX04_10; import android.app.Activity; import android.os.Bundle; /*��������ʹ�õ���class*/ import android.content.Context; import android.content.res.TypedArray; import android.view.View; import android.view.ViewGroup; import android.widget.AdapterView; import android.widget.BaseAdapter; import android.widget.Gallery; import android.widget.ImageView; import android.widget.Toast; import android.widget.AdapterView.OnItemClickListener; public class EX04_10 extends Activity { /** Called when the activity is first created. */ @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.main); /*͸��findViewByIdȡ��*/ Gallery g = (Gallery) findViewById(R.id.mygallery); /*����һImageAdapter���趨��Gallery����*/ g.setAdapter(new ImageAdapter(this)); /*�趨һ��itemclickListener��Toast����ѡͼƬ��λ��*/ g.setOnItemClickListener(new OnItemClickListener() { public void onItemClick(AdapterView parent, View v, int position, long id) { Toast.makeText(EX04_10.this, getString(R.string.my_gallery_text_pre) + position+ getString(R.string.my_gallery_text_post), Toast.LENGTH_SHORT).show(); } }); } /*��дBaseAdapter�Զ���һImageAdapter class*/ public class ImageAdapter extends BaseAdapter { /*�������*/ int mGalleryItemBackground; private Context mContext; /*ImageAdapter�Ľ�����*/ public ImageAdapter(Context c) { mContext = c; /* ʹ����res/values/attrs.xml�еĶ��� * ��Gallery����.*/ TypedArray a = obtainStyledAttributes(R.styleable.Gallery); /*ȡ��Gallery���Ե�Index id*/ mGalleryItemBackground = a.getResourceId( R.styleable.Gallery_android_galleryItemBackground, 0); /*�ö����styleable�����ܹ�����ʹ��*/ a.recycle(); } /*һ��Ҫ��д�ķ���getCount,����ͼƬ��Ŀ*/ public int getCount() { return myImageIds.length; } /*һ��Ҫ��д�ķ���getItem,����position*/ public Object getItem(int position) { return position; } /*һ��Ҫ��д�ķ���getItemId,����position*/ public long getItemId(int position) { return position; } /*һ��Ҫ��д�ķ���getView,����һView����*/ public View getView(int position, View convertView, ViewGroup parent) { /*����ImageView����*/ ImageView i = new ImageView(mContext); /*�趨ͼƬ��imageView����*/ i.setImageResource(myImageIds[position]); /*�����趨ͼƬ�Ŀ���*/ i.setScaleType(ImageView.ScaleType.FIT_XY); /*�����趨Layout�Ŀ���*/ i.setLayoutParams(new Gallery.LayoutParams(136, 88)); /*�趨Gallery����ͼ*/ i.setBackgroundResource(mGalleryItemBackground); /*����imageView���*/ return i; } /*����һInteger array��ȡ��Ԥ����Drawable��ͼƬid*/ private Integer[] myImageIds = { R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4, R.drawable.photo5, R.drawable.photo6, }; } }