package ru.mirea.belov.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        final Runnable runn1 = new Runnable() {
            public void run() {
                tvInfo.setText("run_1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                tvInfo.setText("run_2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                tvInfo.setText("run_3");
            }
        };

        tvInfo.setText("Минуточку");

        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    tvInfo.postDelayed(runn3, 2000);
                    tvInfo.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}

// Вызываются процессы по очереди 1 -> 2 -> 3
//
// runOnUiThread - Выполняет указанное действие в потоке пользовательского интерфейса.
// Если текущий поток является потоком пользовательского интерфейса, действие выполняется немедленно.
// Если текущий поток не является потоком пользовательского интерфейса, действие отправляется в очередь событий потока пользовательского интерфейса.
//
// В данном случае
// postDelayed - Заставляет Runnable быть добавленным в очередь сообщений для запуска по истечении указанного времени.
// Runnable будет запущен в потоке, к которому прикреплен этот обработчик.
// Временная база SystemClock.uptimeMillis(). Время, проведенное в глубоком сне, добавит дополнительную задержку выполнению.