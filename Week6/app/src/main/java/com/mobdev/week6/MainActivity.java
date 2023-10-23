package com.mobdev.week6;

import static android.widget.Toast.makeText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1);
        this.registerForContextMenu(textView);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1Clicked();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.item1) {
            Toast.makeText(this, "You choose item 1", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.item2) {
            Toast.makeText(this, "You choose item 2", Toast.LENGTH_LONG).show();
        }else if (itemId == R.id.item3) {
            Toast.makeText(this, "You choose item 3", Toast.LENGTH_LONG).show();
        }else if (itemId == R.id.item4) {
            Toast.makeText(this, "You choose item 4", Toast.LENGTH_LONG).show();
        }else if (itemId == R.id.item4_1) {
            Toast.makeText(this, "You choose item 4.1", Toast.LENGTH_LONG).show();
        }else if (itemId == R.id.item4_2) {
            Toast.makeText(this, "You choose item 4.2", Toast.LENGTH_LONG).show();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.contextItem1) {
            Toast.makeText(this, "You choose item 1", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.contextItem2) {
            Toast.makeText(this, "You choose item 2", Toast.LENGTH_LONG).show();
        }else if (itemId == R.id.contextItem3) {
            Toast.makeText(this, "You choose item 3", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    private void button1Clicked() {
        PopupMenu popupMenu = new PopupMenu(this, button2);
        popupMenu.inflate(R.menu.popup_menu);

        Menu menu = popupMenu.getMenu();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if (itemId == R.id.popup1) {
                    Toast.makeText(getApplicationContext(), "You choose pop 1", Toast.LENGTH_LONG).show();
                    return true;
                } else if (itemId == R.id.popup2) {
                    Toast.makeText(getApplicationContext(), "You choose pop 2", Toast.LENGTH_LONG).show();
                    return true;

                }else if (itemId == R.id.popup3) {
                    Toast.makeText(getApplicationContext(), "You choose pop 3", Toast.LENGTH_LONG).show();
                    return true;

                }
                return false;
            }
        });
        popupMenu.show();
    }
}