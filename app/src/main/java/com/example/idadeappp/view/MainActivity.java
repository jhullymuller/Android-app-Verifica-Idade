package com.example.idadeappp.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idadeappp.R;
import com.example.idadeappp.model.model.Pessoa;
import com.example.idadeappp.model.model.PessoaBo;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editIdade;
    private TextView telaResultado;
    private LinearLayout layoutResultado;

    //Adicionar evento de clique no botao
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    private void initialize() {
        editNome = findViewById(R.id.editNome);
        editIdade = findViewById(R.id.editIdade);
        telaResultado = findViewById(R.id.telaResultado);
        layoutResultado = findViewById(R.id.layoutResultado);

        //Inserção da chamada do botão fechar

        btnFechar = findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fecharAction();

                }
            });
    }
     private void fecharAction(){
         AlertDialog.Builder alerta = new AlertDialog.Builder(this);
         alerta.setTitle(R.string.fechando_app);
         alerta.setMessage(R.string.realmente_fechar_app);
         alerta.setNegativeButton(R.string.nao, null);
         alerta.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Toast.makeText(MainActivity.this, "Clicou em fechar", Toast.LENGTH_SHORT).show();
                 MainActivity.this.finish();
             }
         });
         alerta.setNeutralButton("Limpar Tela", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                limparTela();
             }
         });
        alerta.show();

        }

    @SuppressLint("SetTextI18n")
    public  void verificar(View v){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(editNome.getText().toString());
        pessoa.setIdade(editIdade.getText().toString());

        if(!PessoaBo.validadarNome(pessoa.getNome())){
            Toast.makeText(this,getString(R.string.erro_nome),Toast.LENGTH_SHORT).show();
            editNome.setError(getString(R.string.erro_nome));
        }else if(!PessoaBo.validadarIdade(pessoa.getIdade())){
            editIdade.setError(getString(R.string.erroIdade));

        }else{
            telaResultado.setText("Olá "+ pessoa.getNome()+", você possui "+ pessoa.getIdade() + " ano(s)");
            ImageView ivResultado = new ImageView(this);

            if(PessoaBo.verificarMaioridade(pessoa.getIdade())){
                ivResultado.setImageResource(R.drawable.maior_idade);
            }else{
                ivResultado.setImageResource(R.drawable.menor_de_idade_ou_de_menor);
            } layoutResultado.removeAllViews();
            layoutResultado.addView(ivResultado);
            limparCampos();
        }
    }
    private void limparCampos(){
        editNome.setText("");
        editIdade.setText("");
    }
    private void limparTela(){
        limparCampos();
        telaResultado.setText("");
        layoutResultado.removeAllViews();
    }
}

