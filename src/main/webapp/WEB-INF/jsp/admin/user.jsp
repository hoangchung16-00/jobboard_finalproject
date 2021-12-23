<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-date" tagdir="/WEB-INF/tags"%>
<h4 class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300">Company List</h4>
<!-!-- Divs are used just to display the examples. Use only the button. -->

<div class="w-full mb-8 overflow-hidden rounded-lg shadow-xs">
    <div class="w-full overflow-x-auto">
        <table class="w-full whitespace-no-wrap">
            <thead>
            <tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                <th class="px-4 py-3">Name</th>
                <th class="px-4 py-3">Address</th>
                <th class="px-4 py-3">Education</th>
                <th class="px-4 py-3">Email</th>
                <th class="px-4 py-3">Phone</th>
                <th class="px-4 py-3">Gender</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800">
            <c:forEach items="${users}" var="user">
                <tr class="text-gray-700 dark:text-gray-400">
                    <td class="px-4 py-3">
                        <div class="flex items-center text-sm">
                            <!-- Avatar with inset shadow -->
                            <div class="relative hidden w-8 h-8 mr-3 rounded-full md:block">
                                <img class="object-cover w-full h-full rounded-full" src="/image/${user.image}" alt="" loading="lazy"/>
                                <div class="absolute inset-0 rounded-full shadow-inner" aria-hidden="true"></div>
                            </div>
                            <div>
                                <p class="font-semibold">${user.name}</p>
                                <p class="text-xs text-gray-600 dark:text-gray-400">dob: <tag-date:date date="${user.dob}"/></p>
                            </div>
                        </div>
                    </td>
                    <td class="px-4 py-3 text-sm">${user.address}</td>
                    <td class="px-4 py-3 text-xs">${user.education}</td>
                    <td class="px-4 py-3 text-sm">${user.email}</td>
                    <td class="px-4 py-3 text-sm">${user.phonenumber}</td>
                    <td class="px-4 py-3 text-sm">${user.gender}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="grid px-4 py-3 text-xs font-semibold tracking-wide text-gray-500 uppercase border-t dark:border-gray-700 bg-gray-50 sm:grid-cols-9 dark:text-gray-400 dark:bg-gray-800">
        <span class="flex items-center col-span-3">
          Showing ${((currentPage-1)*companies.size()+1)}-${currentPage*companies.size()} of ${total.toString()}
        </span>
        <span class="col-span-2"></span>
        <!-- Pagination -->
        <span class="flex col-span-4 mt-2 sm:mt-auto sm:justify-end">
          <nav aria-label="Table navigation">
            <ul class="inline-flex items-center">
              <li>
                <c:if test="${currentPage!=1}">
                      <a href="/admin/company?page=${currentPage-1}" class="px-3 py-1 rounded-md rounded-l-lg focus:outline-none focus:shadow-outline-purple"  aria-label="Previous">
                          <
                      </a>
                </c:if>
              </li>
                <c:forEach begin="1" end="${totalPage}" varStatus="index">
                    <li>
                        <a href="/admin/company?page=${index.index}" class="px-3 py-1 <c:if test="${index.index==currentPage}">text-white transition-colors duration-150 bg-purple-600 border border-r-0 border-purple-600</c:if> rounded-md focus:outline-none focus:shadow-outline-purple">
                                ${index.index}
                        </a>
                    </li>
                </c:forEach>
              <li>
                  <c:if test="${currentPage!=totalPage}">
                      <a href="/admin/company?page=${currentPage+1}" class="px-3 py-1 rounded-md rounded-r-lg focus:outline-none focus:shadow-outline-purple" aria-label="Next">
                          >
                      </a>
                  </c:if>
              </li>
            </ul>
          </nav>
        </span>
    </div>
</div>