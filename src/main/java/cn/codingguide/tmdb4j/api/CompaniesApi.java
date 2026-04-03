package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.companies.CompanyAlternativeNamesResponse;
import cn.codingguide.tmdb4j.model.companies.CompanyDetails;
import cn.codingguide.tmdb4j.model.companies.CompanyImagesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public interface CompaniesApi {

    /**
     * Get details of a production company by its ID.
     * The response includes company information such as name, description, headquarters, homepage, logo, and parent
     * company.
     * <p>
     * 根据公司 ID 获取制作公司的详细信息。
     * 响应包含公司信息，如名称、描述、总部、主页、标志以及母公司。
     *
     * @param companyId The unique identifier of the company.
     *                  公司的唯一标识符。
     * @return CompanyDetails object containing the company information.
     * 包含公司信息的 CompanyDetails 对象。
     * @see <a href="https://developer.themoviedb.org/reference/company-details">API LINK</a>
     */
    @GET("company/{company_id}")
    Call<CompanyDetails> getCompanyDetails(
            @Path("company_id") int companyId
    );

    /**
     * Get a list of alternative names for a specific company.
     * The response includes the company ID and a list of alternative names with language and country codes.
     * <p>
     * 获取指定公司的备选名称列表。
     * 响应包含公司 ID 以及带有语言和国家代码的备选名称列表。
     *
     * @param companyId The unique identifier of the company.
     *                  公司的唯一标识符。
     * @return CompanyAlternativeNamesResponse containing the list of alternative names.
     * 包含备选名称列表的公司备选名称响应。
     * @see <a href="https://developer.themoviedb.org/reference/company-alternative-names">API LINK</a>
     */
    @GET("company/{company_id}/alternative_names")
    Call<CompanyAlternativeNamesResponse> getCompanyAlternativeNames(
            @Path("company_id") int companyId
    );

    /**
     * Get logo images for a specific company.
     * The response includes a list of logo images with metadata such as dimensions, language, and vote statistics.
     * <p>
     * 获取指定公司的标志图片。
     * 响应包含标志图片列表及其元数据（尺寸、语言、投票统计等）。
     *
     * @param companyId The unique identifier of the company.
     *                  公司的唯一标识符。
     * @return CompanyImagesResponse containing the list of logo images.
     * 包含标志图片列表的公司图片响应。
     * @see <a href="https://developer.themoviedb.org/reference/company-images">API LINK</a>
     */
    @GET("company/{company_id}/images")
    Call<CompanyImagesResponse> getCompanyImages(
            @Path("company_id") int companyId
    );

}
