package com.iteso.tarea2;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    ImageButton likeBtn;
    RadioButton colorGrayRadio;
    RadioButton colorBrownRadio;
    RadioButton colorPinkRadio;
    RadioButton colorBlackRadio;
    Button sizeMediumBtn;
    Button sizeSmallBtn;
    Button sizeLargeBtn;
    Button sizeXLargeBtn;
    Button addToCartBtn;
    int colorSelected;
    int sizeSelected;
    boolean addedToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        likeBtn = (ImageButton) findViewById(R.id.main_like_btn);
        colorGrayRadio = (RadioButton)findViewById(R.id.main_colorgray_radio);
        colorBrownRadio = (RadioButton)findViewById(R.id.main_colorgray_radio);
        colorPinkRadio = (RadioButton)findViewById(R.id.main_colorpink_radio);
        colorBlackRadio = (RadioButton)findViewById(R.id.main_colorblack_radio);
        sizeMediumBtn = (Button)findViewById(R.id.main_medium_btn);
        sizeSmallBtn = (Button)findViewById(R.id.main_small_btn);
        sizeLargeBtn = (Button)findViewById(R.id.main_large_btn);
        sizeXLargeBtn = (Button)findViewById(R.id.main_xlarge_btn);
        addToCartBtn = (Button)findViewById(R.id.main_addtocart_btn);


        //AddListeners
        likeBtn.setOnClickListener(likeBtnListener);
        sizeMediumBtn.setOnClickListener(sizeBtnListener);
        sizeSmallBtn.setOnClickListener(sizeBtnListener);
        sizeLargeBtn.setOnClickListener(sizeBtnListener);
        sizeXLargeBtn.setOnClickListener(sizeBtnListener);
        addToCartBtn.setOnClickListener(addToCartBtnListener);
        colorGrayRadio.setOnClickListener(colorRadioListener);
        colorBrownRadio.setOnClickListener(colorRadioListener);
        colorPinkRadio.setOnClickListener(colorRadioListener);
        colorBlackRadio.setOnClickListener(colorRadioListener);

        if(savedInstanceState!=null){
           colorSelected=savedInstanceState.getInt("colorSelected");
           sizeSelected=savedInstanceState.getInt("sizeSelected");
           addedToCart=savedInstanceState.getBoolean("addedToCart");
           switch(colorSelected){
               case 0:
                   colorGrayRadio.performClick();
                   break;
               case 1:
                   colorBrownRadio.performClick();
                   break;
               case 2:
                   colorPinkRadio.performClick();
                   break;
               case 3:
                   colorBlackRadio.performClick();
                   break;
           }
           switch(sizeSelected){
               case 0:
                   sizeMediumBtn.performClick();
                   break;
               case 1:
                   sizeSmallBtn.performClick();
                   break;
               case 2:
                   sizeLargeBtn.performClick();
                   break;
               case 3:
                   sizeXLargeBtn.performClick();
                   break;
           }
           if(addedToCart){
               addedToCart=false;
               addToCartBtn.performClick();
           }
        }else{
            colorGrayRadio.performClick();
            sizeMediumBtn.performClick();
            addedToCart=false;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("colorSelected",colorSelected);
        outState.putInt("sizeSelected",sizeSelected);
        outState.putBoolean("addedToCart",addedToCart);
        super.onSaveInstanceState(outState);
    }

    private View.OnClickListener likeBtnListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),R.string.main_addlike_toast, Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener sizeBtnListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            sizeMediumBtn.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.main_size_button));
            sizeMediumBtn.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.dark_brown_color));
            sizeSmallBtn.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.main_size_button));
            sizeSmallBtn.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.dark_brown_color));
            sizeLargeBtn.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.main_size_button));
            sizeLargeBtn.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.dark_brown_color));
            sizeXLargeBtn.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.main_size_button));
            sizeXLargeBtn.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.dark_brown_color));
            switch(view.getId()){
                case R.id.main_medium_btn:
                    sizeMediumBtn.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.main_size_button_visto));
                    sizeMediumBtn.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white_color));
                    sizeSelected=0;
                    break;
                case R.id.main_small_btn:
                    sizeSmallBtn.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.main_size_button_visto));
                    sizeSmallBtn.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white_color));
                    sizeSelected=1;
                    break;
                case R.id.main_large_btn:
                    sizeLargeBtn.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.main_size_button_visto));
                    sizeLargeBtn.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white_color));
                    sizeSelected=2;
                    break;
                case R.id.main_xlarge_btn:
                    sizeXLargeBtn.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.main_size_button_visto));
                    sizeXLargeBtn.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white_color));
                    sizeSelected=3;
                    break;
            }
        }
    };
    private View.OnClickListener addToCartBtnListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(addedToCart==false) {
                addToCartBtn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.light_gray2_color));
                addToCartBtn.setText(getText(R.string.main_addtocart_btn_selected));
                addedToCart = true;
                Snackbar.make(view, getText(R.string.main_addtocart_btn_selected), Snackbar.LENGTH_INDEFINITE).setAction(R.string.main_undo_snackBar_btn, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addToCartBtn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.dark_gray_color));
                        addToCartBtn.setText(getText(R.string.main_addtocart_btn));
                        addedToCart = false;
                    }
                }).show();
            }else{
                Toast.makeText(getApplicationContext(),R.string.main_addtocart_btn_selected_toast, Toast.LENGTH_SHORT).show();
            }
        }
    };
    private View.OnClickListener colorRadioListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.main_colorgray_radio:
                    colorSelected=0;
                    break;
                case R.id.main_colorbrown_radio:
                    colorSelected=1;
                    break;
                case R.id.main_colorpink_radio:
                    colorSelected=2;
                    break;
                case R.id.main_colorblack_radio:
                    colorSelected=3;
                    break;
            }
        }
    };
}
