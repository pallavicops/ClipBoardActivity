package dev.pallavi.clipboardactivity;



import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnCopy,btnPaste;
    EditText t1,t2;
    ClipboardManager clipboardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.copyText);
        t2=findViewById(R.id.pasteText);
        btnCopy=findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(this);
        btnPaste=findViewById(R.id.btnPaste);
        btnPaste.setOnClickListener(this);
        clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnCopy))
        {
            ClipData myclip;
            String data=t1.getText().toString();
            myclip=ClipData.newPlainText("text",data);
            clipboardManager.setPrimaryClip(myclip);
            Toast.makeText(getBaseContext(),"Text Copied",Toast.LENGTH_SHORT).show();


        }
        else if(v.equals(btnPaste))
        {
            ClipData abc=clipboardManager.getPrimaryClip();
            ClipData.Item item=abc.getItemAt(0);
            t2.setText(item.getText().toString());
            Toast.makeText(getBaseContext(),"Text Pasted",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getBaseContext(),"Invalid",Toast.LENGTH_SHORT).show();

    }
}