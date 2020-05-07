package vn.edu.ntu.phuocthai.adaterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView show;
    ListView TinhThanh;
    Spinner sp;
    String[] arraytinhthanh;
    String[] arraydate;
    ArrayAdapter<String> adatertinhthanh;
    ArrayAdapter<String> adaterdate;
    AutoCompleteTextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addViews(){
        TinhThanh = findViewById(R.id.tinhthanh);
        sp = findViewById(R.id.date);
        arraytinhthanh = getResources().getStringArray(R.array.tinh_thanh);
        adatertinhthanh = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arraytinhthanh);
        TinhThanh.setAdapter(adatertinhthanh);
        arraydate = getResources().getStringArray(R.array.Thu);
        adaterdate = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arraydate);
        sp.setAdapter(adaterdate);

        text = findViewById(R.id.autoCompleteTextView);
        text.setAdapter(adatertinhthanh);


        show = findViewById(R.id.show_date);
    }

    private void addEvents(){
        TinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String message = adatertinhthanh.getItem(position);
                Toast.makeText(MainActivity.this, "Bạn chọn: " + message, Toast.LENGTH_SHORT).show();
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String message = adaterdate.getItem(position);
                show.setText(message);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
