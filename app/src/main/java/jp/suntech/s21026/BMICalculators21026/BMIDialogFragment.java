package jp.suntech.s21026.BMICalculators21026;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class BMIDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("警告")
                .setMessage("適切な肥満度を求めるためには、6歳未満の場合はカウブ指数が、6歳から15歳まではローレル指数が使われます。本アプリはBIMのみに対応しているため、16歳以下の正確な肥満度が計測できません。")
                .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // ボタンを押した時の処理
                    }
                });
        return builder.create();
    }
}
