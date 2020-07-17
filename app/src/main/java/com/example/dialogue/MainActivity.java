package com.example.dialogue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onDialog1(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("기본대화상자");
        dialog.setMessage("이것은 메시지입니다.");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast("확인클릭");
            }
        });
        dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast("취소됨!");
            }
        });
        dialog.show();

        }
    public void Toast (String str){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
    public void onDialog2(View view) {
        final int[] selectedIndex = {1};
        final String data[] = {"치킨"," 피자", "스파게티", "짜장면"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("라디오 대화상자");
        dialog.setSingleChoiceItems(data, selectedIndex[0], new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selectedIndex[0] = i;
            }
        });
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast(data[selectedIndex[0]]+"를 선택하셨습니다.");
            }
        });
        dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast("취소됨!");
            }
        });
        dialog.show();

    }
    public void onDialog3(View view) {
        final String data2[] = {"피아노", "독서", "게임"};
        final boolean checked[] = {true, true, false};

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("체크박스 대화상자");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String str = "";
                for (int i = 0; i < checked.length; i++) {
                    if (checked[i]) str += " " + data2[i];
                }
                Toast(str + " 선택됨");
            }
        });

        dialog.setMultiChoiceItems(data2, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                checked[i] = b;
            }
        });
        dialog.show();
    }
    public void onDialog4(View view) {
        View dlgView = View.inflate(this, R.layout.dialog, null);
        final EditText et = dlgView.findViewById(R.id.etName);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("사용자 정의 대화상자");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = et.getText().toString();
                Toast(str);
            }
        });
        dialog.setNegativeButton("취소", null);
        dialog.setView(dlgView);
        dialog.show();

    }

    public void onDialog5(View view) {
        View dlgView = View.inflate(this, R.layout.dialog2, null);
        final EditText etname = dlgView.findViewById(R.id.etName);
        final EditText etage = dlgView.findViewById(R.id.etage);
        final EditText etmajor = dlgView.findViewById(R.id.etmajor);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("사용자 정보입력");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = etname.getText().toString();
                String strage = etage.getText().toString();
                String strmajor = etmajor.getText().toString();
                Toast("사용자 정보: " + str +", "+ strage + ", "+ strmajor);
            }
        });
        dialog.setNegativeButton("취소", null);
        dialog.setView(dlgView);
        dialog.show();

    }

}