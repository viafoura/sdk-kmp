package viafoura.sdk.demo

import android.graphics.Color
import com.viafourasdk.src.fragments.previewcomments.VFPreviewCommentsFragment
import com.viafourasdk.src.fragments.previewcomments.VFPreviewCommentsFragmentBuilder
import com.viafourasdk.src.model.local.VFArticleMetadata
import com.viafourasdk.src.model.local.VFColors
import com.viafourasdk.src.model.local.VFSettings

actual class NativeScreenProvider {
    actual fun getCommentsContainer(containerId: String, loginCallback: () -> Unit): Any {
        val settings = VFSettings(VFColors(Color.RED, Color.RED));
        val metadata = VFArticleMetadata("", "", "", "")
        val builder = VFPreviewCommentsFragmentBuilder(containerId, metadata, loginCallback, settings);
        return builder.build();
    }
}
