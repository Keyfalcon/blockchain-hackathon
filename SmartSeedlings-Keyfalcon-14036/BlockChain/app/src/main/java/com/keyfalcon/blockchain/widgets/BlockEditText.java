package com.keyfalcon.blockchain.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.keyfalcon.blockchain.R;

/**
 * Created by Shylesh on 19-Jan-18.
 */

public class BlockEditText extends AppCompatEditText {

    public BlockEditText(Context context) {
        super(context);
    }

    public BlockEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.block_edit_text_style);
    }

    public BlockEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
