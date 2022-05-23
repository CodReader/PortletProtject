package portletconnect.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import portletconnect.constants.PortletConnectPortletKeys;

import javax.portlet.Portlet;

/**
 * @author bogdan
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=PortletConnect",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + PortletConnectPortletKeys.PORTLETCONNECT,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)

public class PortletConnectPortlet extends MVCPortlet {
    @Reference
    private randoms.portlet.RandomsPortletService randomsPortletService;

    @Activate
    public void activate() {
        randomsPortletService.randomGenerator();
//        System.out.println(123);
    }
}