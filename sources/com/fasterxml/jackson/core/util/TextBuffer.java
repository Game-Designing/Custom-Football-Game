package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.p134io.NumberInput;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class TextBuffer {
    static final char[] NO_CHARS = new char[0];
    private final BufferRecycler _allocator;
    private char[] _currentSegment;
    private int _currentSize;
    private boolean _hasSegments;
    private char[] _inputBuffer;
    private int _inputLen;
    private int _inputStart;
    private char[] _resultArray;
    private String _resultString;
    private int _segmentSize;
    private ArrayList<char[]> _segments;

    public TextBuffer(BufferRecycler allocator) {
        this._allocator = allocator;
    }

    public void releaseBuffers() {
        if (this._allocator == null) {
            resetWithEmpty();
        } else if (this._currentSegment != null) {
            resetWithEmpty();
            char[] buf = this._currentSegment;
            this._currentSegment = null;
            this._allocator.releaseCharBuffer(2, buf);
        }
    }

    public void resetWithEmpty() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithShared(char[] buf, int start, int len) {
        this._resultString = null;
        this._resultArray = null;
        this._inputBuffer = buf;
        this._inputStart = start;
        this._inputLen = len;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithCopy(char[] buf, int start, int len) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = buf(len);
        }
        this._segmentSize = 0;
        this._currentSize = 0;
        append(buf, start, len);
    }

    public void resetWithString(String value) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = value;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        this._currentSize = 0;
    }

    private char[] buf(int needed) {
        BufferRecycler bufferRecycler = this._allocator;
        if (bufferRecycler != null) {
            return bufferRecycler.allocCharBuffer(2, needed);
        }
        return new char[Math.max(needed, 1000)];
    }

    private void clearSegments() {
        this._hasSegments = false;
        this._segments.clear();
        this._segmentSize = 0;
        this._currentSize = 0;
    }

    public int size() {
        if (this._inputStart >= 0) {
            return this._inputLen;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this._resultString;
        if (str != null) {
            return str.length();
        }
        return this._segmentSize + this._currentSize;
    }

    public int getTextOffset() {
        int i = this._inputStart;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public char[] getTextBuffer() {
        if (this._inputStart >= 0) {
            return this._inputBuffer;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        String str = this._resultString;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this._resultArray = charArray;
            return charArray;
        } else if (this._hasSegments) {
            return contentsAsArray();
        } else {
            char[] cArr2 = this._currentSegment;
            if (cArr2 == null) {
                cArr2 = NO_CHARS;
            }
            return cArr2;
        }
    }

    public String contentsAsString() {
        if (this._resultString == null) {
            char[] cArr = this._resultArray;
            if (cArr != null) {
                this._resultString = new String(cArr);
            } else {
                int i = this._inputStart;
                String str = "";
                if (i >= 0) {
                    int i2 = this._inputLen;
                    if (i2 < 1) {
                        this._resultString = str;
                        return str;
                    }
                    this._resultString = new String(this._inputBuffer, i, i2);
                } else {
                    int segLen = this._segmentSize;
                    int currLen = this._currentSize;
                    if (segLen == 0) {
                        if (currLen != 0) {
                            str = new String(this._currentSegment, 0, currLen);
                        }
                        this._resultString = str;
                    } else {
                        StringBuilder sb = new StringBuilder(segLen + currLen);
                        ArrayList<char[]> arrayList = this._segments;
                        if (arrayList != null) {
                            int len = arrayList.size();
                            for (int i3 = 0; i3 < len; i3++) {
                                char[] curr = (char[]) this._segments.get(i3);
                                sb.append(curr, 0, curr.length);
                            }
                        }
                        sb.append(this._currentSegment, 0, this._currentSize);
                        this._resultString = sb.toString();
                    }
                }
            }
        }
        return this._resultString;
    }

    public char[] contentsAsArray() {
        char[] result = this._resultArray;
        if (result != null) {
            return result;
        }
        char[] resultArray = resultArray();
        char[] result2 = resultArray;
        this._resultArray = resultArray;
        return result2;
    }

    public BigDecimal contentsAsDecimal() throws NumberFormatException {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return NumberInput.parseBigDecimal(cArr);
        }
        int i = this._inputStart;
        if (i >= 0) {
            char[] cArr2 = this._inputBuffer;
            if (cArr2 != null) {
                return NumberInput.parseBigDecimal(cArr2, i, this._inputLen);
            }
        }
        if (this._segmentSize == 0) {
            char[] cArr3 = this._currentSegment;
            if (cArr3 != null) {
                return NumberInput.parseBigDecimal(cArr3, 0, this._currentSize);
            }
        }
        return NumberInput.parseBigDecimal(contentsAsArray());
    }

    public double contentsAsDouble() throws NumberFormatException {
        return NumberInput.parseDouble(contentsAsString());
    }

    public int contentsAsInt(boolean neg) {
        int i = this._inputStart;
        if (i >= 0) {
            char[] cArr = this._inputBuffer;
            if (cArr != null) {
                if (neg) {
                    return -NumberInput.parseInt(cArr, i + 1, this._inputLen - 1);
                }
                return NumberInput.parseInt(cArr, i, this._inputLen);
            }
        }
        if (neg) {
            return -NumberInput.parseInt(this._currentSegment, 1, this._currentSize - 1);
        }
        return NumberInput.parseInt(this._currentSegment, 0, this._currentSize);
    }

    public long contentsAsLong(boolean neg) {
        int i = this._inputStart;
        if (i >= 0) {
            char[] cArr = this._inputBuffer;
            if (cArr != null) {
                if (neg) {
                    return -NumberInput.parseLong(cArr, i + 1, this._inputLen - 1);
                }
                return NumberInput.parseLong(cArr, i, this._inputLen);
            }
        }
        if (neg) {
            return -NumberInput.parseLong(this._currentSegment, 1, this._currentSize - 1);
        }
        return NumberInput.parseLong(this._currentSegment, 0, this._currentSize);
    }

    public void append(char c) {
        if (this._inputStart >= 0) {
            unshare(16);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] curr = this._currentSegment;
        if (this._currentSize >= curr.length) {
            expand(1);
            curr = this._currentSegment;
        }
        int i = this._currentSize;
        this._currentSize = i + 1;
        curr[i] = c;
    }

    public void append(char[] c, int start, int len) {
        if (this._inputStart >= 0) {
            unshare(len);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] curr = this._currentSegment;
        int length = curr.length;
        int i = this._currentSize;
        int max = length - i;
        if (max >= len) {
            System.arraycopy(c, start, curr, i, len);
            this._currentSize += len;
            return;
        }
        if (max > 0) {
            System.arraycopy(c, start, curr, i, max);
            start += max;
            len -= max;
        }
        do {
            expand(len);
            int amount = Math.min(this._currentSegment.length, len);
            System.arraycopy(c, start, this._currentSegment, 0, amount);
            this._currentSize += amount;
            start += amount;
            len -= amount;
        } while (len > 0);
    }

    public void append(String str, int offset, int len) {
        if (this._inputStart >= 0) {
            unshare(len);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] curr = this._currentSegment;
        int length = curr.length;
        int i = this._currentSize;
        int max = length - i;
        if (max >= len) {
            str.getChars(offset, offset + len, curr, i);
            this._currentSize += len;
            return;
        }
        if (max > 0) {
            str.getChars(offset, offset + max, curr, i);
            len -= max;
            offset += max;
        }
        do {
            expand(len);
            int amount = Math.min(this._currentSegment.length, len);
            str.getChars(offset, offset + amount, this._currentSegment, 0);
            this._currentSize += amount;
            offset += amount;
            len -= amount;
        } while (len > 0);
    }

    public char[] getCurrentSegment() {
        if (this._inputStart >= 0) {
            unshare(1);
        } else {
            char[] curr = this._currentSegment;
            if (curr == null) {
                this._currentSegment = buf(0);
            } else if (this._currentSize >= curr.length) {
                expand(1);
            }
        }
        return this._currentSegment;
    }

    public char[] emptyAndGetCurrentSegment() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        char[] curr = this._currentSegment;
        if (curr != null) {
            return curr;
        }
        char[] buf = buf(0);
        char[] curr2 = buf;
        this._currentSegment = buf;
        return curr2;
    }

    public int getCurrentSegmentSize() {
        return this._currentSize;
    }

    public void setCurrentLength(int len) {
        this._currentSize = len;
    }

    public String setCurrentAndReturn(int len) {
        this._currentSize = len;
        if (this._segmentSize > 0) {
            return contentsAsString();
        }
        int currLen = this._currentSize;
        String str = currLen == 0 ? "" : new String(this._currentSegment, 0, currLen);
        this._resultString = str;
        return str;
    }

    public char[] finishCurrentSegment() {
        if (this._segments == null) {
            this._segments = new ArrayList<>();
        }
        this._hasSegments = true;
        this._segments.add(this._currentSegment);
        int oldLen = this._currentSegment.length;
        this._segmentSize += oldLen;
        this._currentSize = 0;
        int newLen = (oldLen >> 1) + oldLen;
        if (newLen < 1000) {
            newLen = 1000;
        } else if (newLen > 262144) {
            newLen = Opcodes.ASM4;
        }
        char[] curr = carr(newLen);
        this._currentSegment = curr;
        return curr;
    }

    public char[] expandCurrentSegment() {
        char[] curr = this._currentSegment;
        int len = curr.length;
        int newLen = (len >> 1) + len;
        if (newLen > 262144) {
            newLen = len + (len >> 2);
        }
        char[] copyOf = Arrays.copyOf(curr, newLen);
        this._currentSegment = copyOf;
        return copyOf;
    }

    public String toString() {
        return contentsAsString();
    }

    private void unshare(int needExtra) {
        int sharedLen = this._inputLen;
        this._inputLen = 0;
        char[] inputBuf = this._inputBuffer;
        this._inputBuffer = null;
        int start = this._inputStart;
        this._inputStart = -1;
        int needed = sharedLen + needExtra;
        char[] cArr = this._currentSegment;
        if (cArr == null || needed > cArr.length) {
            this._currentSegment = buf(needed);
        }
        if (sharedLen > 0) {
            System.arraycopy(inputBuf, start, this._currentSegment, 0, sharedLen);
        }
        this._segmentSize = 0;
        this._currentSize = sharedLen;
    }

    private void expand(int minNewSegmentSize) {
        if (this._segments == null) {
            this._segments = new ArrayList<>();
        }
        char[] curr = this._currentSegment;
        this._hasSegments = true;
        this._segments.add(curr);
        this._segmentSize += curr.length;
        this._currentSize = 0;
        int oldLen = curr.length;
        int newLen = (oldLen >> 1) + oldLen;
        if (newLen < 1000) {
            newLen = 1000;
        } else if (newLen > 262144) {
            newLen = Opcodes.ASM4;
        }
        this._currentSegment = carr(newLen);
    }

    private char[] resultArray() {
        String str = this._resultString;
        if (str != null) {
            return str.toCharArray();
        }
        if (this._inputStart >= 0) {
            int len = this._inputLen;
            if (len < 1) {
                return NO_CHARS;
            }
            int start = this._inputStart;
            if (start == 0) {
                return Arrays.copyOf(this._inputBuffer, len);
            }
            return Arrays.copyOfRange(this._inputBuffer, start, start + len);
        }
        int size = size();
        if (size < 1) {
            return NO_CHARS;
        }
        int offset = 0;
        char[] result = carr(size);
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int len2 = arrayList.size();
            for (int i = 0; i < len2; i++) {
                char[] curr = (char[]) this._segments.get(i);
                int currLen = curr.length;
                System.arraycopy(curr, 0, result, offset, currLen);
                offset += currLen;
            }
        }
        System.arraycopy(this._currentSegment, 0, result, offset, this._currentSize);
        return result;
    }

    private char[] carr(int len) {
        return new char[len];
    }
}
