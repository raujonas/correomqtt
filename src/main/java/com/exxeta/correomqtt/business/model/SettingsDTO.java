package com.exxeta.correomqtt.business.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SettingsDTO {
    private boolean extraFeatures;
    private boolean unzippingPayload;
    private boolean base64DecodingPayload;
    private boolean useRegexForSearch;
    private boolean useIgnoreCase;
    private Locale savedLocale = null;
    private Locale currentLocale = null;

    public boolean isExtraFeatures() {
        return extraFeatures;
    }

    public void setExtraFeatures(boolean messageID) {
        this.extraFeatures = messageID;
    }

    public boolean isUnzippingPayload() {
        return unzippingPayload;
    }

    public void setUnzippingPayload(boolean unzippingPayload) {
        this.unzippingPayload = unzippingPayload;
    }

    public boolean isBase64DecodingPayload() {
        return base64DecodingPayload;
    }

    public void setBase64DecodingPayload(boolean base64DecodingPayload) {
        this.base64DecodingPayload = base64DecodingPayload;
    }

    public boolean isUseRegexForSearch() {
        return useRegexForSearch;
    }

    public void setUseRegexForSearch(boolean useRegexForSearch) {
        this.useRegexForSearch = useRegexForSearch;
    }

    public boolean isUseIgnoreCase() {
        return useIgnoreCase;
    }

    public void setUseIgnoreCase(boolean useIgnoreCase) {
        this.useIgnoreCase = useIgnoreCase;
    }

    public Locale getSavedLocale() {
        return savedLocale;
    }

    public void setSavedLocale(Locale savedLocale) {
        this.savedLocale = savedLocale;
    }
}
