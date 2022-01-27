<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="currentPage" required="true" type="java.lang.Integer" %>
<%@ attribute name="size" required="true" type="java.lang.Integer" %>
<%@ attribute name="total" required="true" type="java.lang.Integer" %>
<%@ attribute name="totalPage" required="true" type="java.lang.Integer" %>
<div class="grid px-4 py-3 text-xs font-semibold tracking-wide text-gray-500 uppercase border-t dark:border-gray-700 bg-gray-50 sm:grid-cols-9 dark:text-gray-400 dark:bg-gray-800">
    <span class="flex items-center col-span-3">
      Showing ${((currentPage-1)*10+1)}-${currentPage*10} of ${total.toString()}
    </span>
    <span class="col-span-2"></span>
    <!-- Pagination -->
    <span class="flex col-span-4 mt-2 sm:mt-auto sm:justify-end">
      <nav aria-label="Table navigation">
        <ul class="inline-flex items-center">
          <li>
            <c:if test="${currentPage!=1}">
              <a href="?page=${currentPage-1}" class="px-3 py-1 rounded-md rounded-l-lg focus:outline-none focus:shadow-outline-purple"  aria-label="Previous">
                  <
              </a>
            </c:if>
          </li>
            <c:forEach begin="1" end="${totalPage}" varStatus="index">
                <li>
                    <a href="?page=${index.index}" class="px-3 py-1 <c:if test="${index.index==currentPage}">text-white transition-colors duration-150 bg-purple-600 border border-r-0 border-purple-600</c:if> rounded-md focus:outline-none focus:shadow-outline-purple">
                        ${index.index}
                    </a>
                </li>
            </c:forEach>
          <li>
              <c:if test="${currentPage!=totalPage}">
                  <a href="?page=${currentPage+1}" class="px-3 py-1 rounded-md rounded-r-lg focus:outline-none focus:shadow-outline-purple" aria-label="Next">
                      >
                  </a>
              </c:if>
          </li>
        </ul>
      </nav>
    </span>
</div>