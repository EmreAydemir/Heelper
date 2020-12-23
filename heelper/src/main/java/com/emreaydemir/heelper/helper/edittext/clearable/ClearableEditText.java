package com.emreaydemir.heelper.helper.edittext.clearable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatEditText;

import com.emreaydemir.heelper.R;
import com.emreaydemir.heelper.constants.ConstantsColor;


public class ClearableEditText extends AppCompatEditText implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcherAdapter.TextWatcherListener {

    public static enum Location {
        LEFT(0), RIGHT(2);

        final int idx;

        private Location(int idx) {
            this.idx = idx;
        }
    }

    public interface Listener {
        void didClearText();
    }

    public ClearableEditText(Context context) {
        super(context);
        init();
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyEditText);
        mBackgroundColor = a.getColor(R.styleable.MyEditText_myedt_backgroundColor, getResources().getColor(R.color.md_grey_200));
        mRadius = a.getDimension(R.styleable.MyEditText_myedt_radius, 30);
        mStrokeDashGap = a.getInt(R.styleable.MyEditText_myedt_strokeDashGap, 0);
        mStrokeDashWidth = a.getInt(R.styleable.MyEditText_myedt_strokeDashWidth, 0);
        mStrokeWidth = a.getInt(R.styleable.MyEditText_myedt_strokeWidth, 0);
        mStrokeColor = a.getColor(R.styleable.MyEditText_myedt_strokeColor, mBackgroundColor);

        mBgFactorRate = a.getFloat(R.styleable.MyEditText_myedt_bgFactorRate, 1f);


        a.recycle();

        notifyChanges();

    }

    public ClearableEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    /**
     * null disables the icon
     */
    public void setIconLocation(Location loc) {
        this.loc = loc;
        initIcon();
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        this.l = l;
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener f) {
        this.f = f;
    }

    private Location loc = Location.RIGHT;

    private Drawable xD;
    private Listener listener;

    private OnTouchListener l;
    private OnFocusChangeListener f;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (getDisplayedDrawable() != null) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int left = (loc == Location.LEFT) ? 0 : getWidth() - getPaddingRight() - xD.getIntrinsicWidth();
            int right = (loc == Location.LEFT) ? getPaddingLeft() + xD.getIntrinsicWidth() : getWidth();
            boolean tappedX = x >= left && x <= right && y >= 0 && y <= (getBottom() - getTop());
            if (tappedX) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    setText("");
                    if (listener != null) {
                        listener.didClearText();
                    }
                }
                return true;
            }
        }
        if (l != null) {
            return l.onTouch(v, event);
        }
        return false;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            setClearIconVisible(isNotEmpty(getText()));
        } else {
            setClearIconVisible(false);
        }
        if (f != null) {
            f.onFocusChange(v, hasFocus);
        }
    }

    @Override
    public void onTextChanged(EditText view, String text) {
        if (isFocused()) {
            setClearIconVisible(isNotEmpty(text));
        }
    }

    @Override
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawables(left, top, right, bottom);
        initIcon();
    }

    private void init() {



        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(new TextWatcherAdapter(this, this));
        initIcon();
        setClearIconVisible(false);
    }

    private void initIcon() {
        xD = null;
        if (loc != null) {
            xD = getCompoundDrawables()[loc.idx];
        }
        if (xD == null) {
            xD = getResources().getDrawable(R.drawable.ic_clear_opaque_24dp);
        }
        xD.setBounds(0, 0, xD.getIntrinsicWidth(), xD.getIntrinsicHeight());
        int min = getPaddingTop() + xD.getIntrinsicHeight() + getPaddingBottom();
        if (getSuggestedMinimumHeight() < min) {
            setMinimumHeight(min);
        }
    }

    private Drawable getDisplayedDrawable() {
        return (loc != null) ? getCompoundDrawables()[loc.idx] : null;
    }

    protected void setClearIconVisible(boolean visible) {
        Drawable[] cd = getCompoundDrawables();
        Drawable displayed = getDisplayedDrawable();
        boolean wasVisible = (displayed != null);
        if (visible != wasVisible) {
            Drawable x = visible ? xD : null;
            super.setCompoundDrawables((loc == Location.LEFT) ? x : cd[0], cd[1], (loc == Location.RIGHT) ? x : cd[2],
                    cd[3]);
        }
    }



    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }


    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }







    private boolean isEnable = true;
    private float mRadius;
    private int mStrokeDashWidth, mStrokeDashGap;
    private int mStrokeColor = 0, mStrokeWidth, mBackgroundColor;

    private float mBgFactorRate = 1f;


    @Override
    public void setEnabled(boolean enabled) {
        isEnable = enabled;
        notifyChanges();
        super.setEnabled(enabled);
    }

    private void notifyChanges() {




        Float factor = 0.8f, factorStorke = 0.9f;

        if (!isEnable) {
            //handling for button disable state
            setAlpha(0.6f);
        }

        if (mStrokeColor == 0) {
            mStrokeColor = manipulateColor(mBackgroundColor, factorStorke);
        }

     //   Drawable pressed = getDrawable1(manipulateColor(mBackgroundColor, factor), mRadius);
        Drawable normal = getDrawable1(mBackgroundColor, mRadius);

        StateListDrawable states = new StateListDrawable();
     //   states.addState(new int[]{android.R.attr.state_pressed}, pressed);
        states.addState(new int[]{}, normal);
        setBackground(states);

    }

    public GradientDrawable getDrawable1(int backgroundColor, float radius) {

        int colors[] = {backgroundColor,
                manipulateColor(backgroundColor, mBgFactorRate)};

        GradientDrawable shape = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);

        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(radius);

        shape.setGradientType(GradientDrawable.LINEAR_GRADIENT);

        shape.setStroke(mStrokeWidth, mStrokeColor);
        if (mStrokeDashGap > 0 || mStrokeDashWidth > 0) {
            shape.setStroke(mStrokeWidth, mStrokeColor, mStrokeDashWidth, mStrokeDashGap);
        }

        return shape;
    }


    private int manipulateColor(int color, float factor) {
        //factor = 0.8f
        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) * factor);
        int g = Math.round(Color.green(color) * factor);
        int b = Math.round(Color.blue(color) * factor);
        return Color.argb(a,
                Math.min(r, 255),
                Math.min(g, 255),
                Math.min(b, 255));
    }





}
