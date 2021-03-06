package cc.metapro.openct.utils;

/*
 *  Copyright 2016 - 2017 OpenCT open source class table
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.support.v4.widget.Space;
import android.support.v7.widget.GridLayout;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutHelper {

    public static void fillGrids(android.widget.GridLayout gridLayout) {
        if (gridLayout == null) return;
        for (int i = 0; i < gridLayout.getRowCount(); i++) {
            for (int j = 0; j < gridLayout.getColumnCount(); j++) {
                android.support.v7.widget.GridLayout.LayoutParams params = new android.support.v7.widget.GridLayout.LayoutParams();
                params.width = Constants.CLASS_WIDTH;
                params.height = Constants.CLASS_BASE_HEIGHT;
                params.rowSpec = android.support.v7.widget.GridLayout.spec(i);
                params.columnSpec = android.support.v7.widget.GridLayout.spec(j);
                gridLayout.addView(new Space(gridLayout.getContext()), params);
            }
        }
    }

    public static void fillGrids(GridLayout gridLayout) {
        if (gridLayout == null) return;
        List<GridLayout.LayoutParams> allChildrenParams = new ArrayList<>();
        int N = gridLayout.getChildCount();
        for (int i = 0; i < N; i++) {
            allChildrenParams.add((GridLayout.LayoutParams) gridLayout.getChildAt(i).getLayoutParams());
        }

        for (int i = 0; i < gridLayout.getRowCount(); i++) {
            for (int j = 0; j < gridLayout.getColumnCount(); j++) {

                android.support.v7.widget.GridLayout.LayoutParams params = new android.support.v7.widget.GridLayout.LayoutParams();
                params.rowSpec = android.support.v7.widget.GridLayout.spec(i);
                params.columnSpec = android.support.v7.widget.GridLayout.spec(j);
                boolean found = false;
                for (GridLayout.LayoutParams p : allChildrenParams) {
                    if (params.equals(p)) {
                        found = true;
                    }
                }
                if (!found) {
                    params.width = Constants.CLASS_WIDTH;
                    params.height = Constants.CLASS_BASE_HEIGHT;
                    Space space = new Space(gridLayout.getContext());
                    gridLayout.addView(space, params);
                }
            }
        }
    }

    public static void addViewToGridlayout(GridLayout gridLayout, View view, GridLayout.LayoutParams params) {
        if (gridLayout == null || view == null || params == null) return;
        removeView(gridLayout, params);
        gridLayout.addView(view, params);
    }

    private static void removeView(GridLayout gridLayout, GridLayout.LayoutParams params) {
        int count = gridLayout.getChildCount();
        for (int i = 0; i < count; i++) {
            View tmp = gridLayout.getChildAt(i);
            GridLayout.LayoutParams layoutParams = (GridLayout.LayoutParams) tmp.getLayoutParams();
            if (params.equals(layoutParams)) {
                gridLayout.removeView(tmp);
                break;
            }
        }
    }

//    private static void removeMoreView(GridLayout gridLayout, GridLayout.LayoutParams params, int startPoint) {
//        int count = gridLayout.getChildCount();
//        for (int i = startPoint; i < count; i++) {
//            View tmp = gridLayout.getChildAt(i);
//            GridLayout.LayoutParams layoutParams = (GridLayout.LayoutParams) tmp.getLayoutParams();
//            if (params.columnSpec.equals(layoutParams.columnSpec)) {
//                gridLayout.removeView(tmp);
//                break;
//            }
//        }
//    }

//    private static View getViewAt(GridLayout gridLayout, GridLayout.LayoutParams params) {
//        int count = gridLayout.getChildCount();
//        for (int k = 0; k < count; k++) {
//            View tmp = gridLayout.getChildAt(k);
//            GridLayout.LayoutParams layoutParams = (GridLayout.LayoutParams) tmp.getLayoutParams();
//            if (params.columnSpec.equals(layoutParams.columnSpec)) {
//                return tmp;
//            }
//        }
//        return null;
//    }

}