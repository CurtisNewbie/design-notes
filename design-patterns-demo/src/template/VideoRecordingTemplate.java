package template;

import java.io.IOException;

/**
 * @author yongjie.zhuang
 */
public abstract class VideoRecordingTemplate {

    public final void record() throws IOException {
        byte[] bytes;
        while (hasNextChunk()) {
            bytes = recordChunk();
            if (hasEnoughSpace(bytes.length)) {
                saveChunk(bytes);
            } else {
                throw new IOException("Not enough space");
            }
        }
    }

    abstract boolean hasEnoughSpace(long chunkSize);

    abstract void saveChunk(byte[] bytes);

    abstract byte[] recordChunk();

    abstract boolean hasNextChunk();

}
