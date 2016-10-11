# Practice with RecyclerView - Fragment - Animation
HelloLotus

# Usage
+ RecyclerView

![alt tag](https://raw.githubusercontent.com/username/projectname/branch/path/to/img.png)

 1.Prepare data
```javascript
ItemData itemsBirthday[] = { new ItemData("Vibrant birthday","$123",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$23.45",R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday","$98.21",R.drawable.birthday_image3),
            new ItemData("Vibrant birthday","$11.66",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$27.42",R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday","$23.01",R.drawable.birthday_image3)};
            
            
```

 2.Init UI
```javascript
view_brithday = (RecyclerView) findViewById(R.id.view_birthday);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        view_brithday.setLayoutManager(layoutManager);
        CustomAdapter mAdapter = new CustomAdapter(itemsBirthday);
        view_brithday.setAdapter(mAdapter);
        view_brithday.setItemAnimator(new DefaultItemAnimator());
        ItemClickSupport.addTo(view_brithday).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent i = new Intent(MainActivity.this, detail_activity.class);
                overridePendingTransition(R.animator.push_out_left, R.animator.pull_in_right);
                startActivity(i);
            }
        });
```

Use CustomAdapter.class to modify item of RecyclerView

+ Fragment

Add fragment in xlm file:
```javascript
<include layout="@layout/fragment_bottom"></include>
```

In code:
```javascript
Fragment FragmentBottom = new FragmentBottom();
        fragmentTransaction.add(R.id.framelayout, FragmentBottom);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
```

+ Animaion
Create file xml in folder animator:
Example: 

push_out_left.xml
```javascript
<?xml version="1.0" encoding="utf-8"?>
<translate xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="300"
    android:fromXDelta="0%"
    android:interpolator="@android:anim/decelerate_interpolator"
    android:toXDelta="-100%" />
```

pull_in_right.xml
```javascript
<?xml version="1.0" encoding="utf-8"?>
<translate xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="300"
    android:fromXDelta="100%"
    android:toXDelta="0%"
    android:interpolator="@android:anim/decelerate_interpolator"
    />
```
```javascript
Intent i = new Intent(MainActivity.this, detail_activity.class);
                overridePendingTransition(R.animator.push_out_left, R.animator.pull_in_right);
                startActivity(i);
```

Link demo: https://www.youtube.com/watch?v=CE34-ODdEw4
